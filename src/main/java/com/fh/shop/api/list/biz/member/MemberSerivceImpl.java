package com.fh.shop.api.list.biz.member;

import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.common.SystemEnum;
import com.fh.shop.api.list.mapper.member.IMemberMapper;
import com.fh.shop.api.list.po.member.Member;
import com.fh.shop.api.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberSerivceImpl implements IMemberSerivce {
    @Autowired
    private IMemberMapper memberMapper;

    public ServerResponce add(Member member) {
        String code = member.getCode();
        String code1 = RedisUtil.get(member.getPhone());
        if (StringUtils.isEmpty(member.getPhone())){
            return ServerResponce.error(SystemEnum.MOBILE_MISS);
        }
        if (StringUtils.isEmpty(code1)){
            return ServerResponce.error(SystemEnum.MOBILE_CODE);
        }
        if (!code.equals(code1)){
            return ServerResponce.error(SystemEnum.CODE_MISS);
        }
        ServerResponce member1 = findMember(member.getUserName());
        if(member1.getCode()!=200){
            return member1;
        }
        member.setRegTime(new Date());
        memberMapper.add(member);
        return ServerResponce.success();
    }

    public ServerResponce findMember(String userName) {
        if(userName==null &&userName.equals("")) {
            return ServerResponce.error(SystemEnum.USER_MISS);
        }
        Member member=memberMapper.findMember(userName);
                if (member!=null){
                return ServerResponce.error(SystemEnum.USER_NAME);
               }
        return ServerResponce.success();
    }
}
