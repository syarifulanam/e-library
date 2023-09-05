package com.anam.elibrary.service;

import com.anam.elibrary.entity.Member;
import com.anam.elibrary.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    public int save(Member member) {
        member.setCreatedAt(new Date());
        member.setUpdatedAt(new Date());
        return memberRepository.save(member);
    }

    public int deleteById(int id) {
        return memberRepository.deleteById(id);
    }

    public int update(Member member) {
        member.setUpdatedAt(new Date());
        return memberRepository.update(member);
    }
}
