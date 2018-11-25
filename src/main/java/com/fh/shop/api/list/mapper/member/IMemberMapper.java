package com.fh.shop.api.list.mapper.member;


import com.fh.shop.api.list.po.member.Member;

public interface IMemberMapper {
    void add(Member member);

    Member findMember(String userName);
}

