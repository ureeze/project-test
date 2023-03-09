package com.example.projecttest.test_4;

import com.example.projecttest.design.Member;
import com.example.projecttest.design.MemberFindService;
import com.example.projecttest.design.MemberRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class MemberFindServiceTest extends IntegrationTestSupport {

    private final MemberRepository memberRepository;
    private final MemberFindService memberFindService;

    public MemberFindServiceTest(MemberRepository memberRepository, MemberFindService memberFindService) {
        this.memberRepository = memberRepository;
        this.memberFindService = memberFindService;
    }

    @Test
    public void findByName_정상조회_케이스() {
        //given
        memberRepository.save(new Member("yun"));

        //when
        final Member member = memberFindService.findByName("yun");

        //then
        then(member.getName()).isEqualTo("yun");
    }

    @AfterAll
    void afterAll() {
        final List<Member> members = memberRepository.findAll();
        System.out.println("=============");
        System.out.println("members size: " + members.size());
        System.out.println("=============");
    }
}