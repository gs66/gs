package com.fh.shop.api.list.api;

import com.fh.shop.api.list.biz.member.IMemberSerivce;
import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.list.po.member.Member;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MemberApi {
    @Resource
    private IMemberSerivce memberSerivce;

    @RequestMapping(value = "/member/add",method = RequestMethod.POST)
    @CrossOrigin(origins = "*",maxAge = 3600)
    public ServerResponce add(Member member){
        return memberSerivce.add(member);
    }

    @RequestMapping("/member/findMemberbyUserName")
    @ResponseBody
    public Object findMember(String userName){
//        ServerResponce member=memberSerivce.findMember(userName);
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(member);
//        mappingJacksonValue.setJsonpFunction(callback);
        return  memberSerivce.findMember(userName);
    }
}
