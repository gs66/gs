package com.fh.shop.api.list.biz.member;

import com.fh.shop.api.common.ServerResponce;
import com.fh.shop.api.list.po.member.Member;

public interface IMemberSerivce {
    ServerResponce add(Member member);

    ServerResponce findMember(String userName);
}
