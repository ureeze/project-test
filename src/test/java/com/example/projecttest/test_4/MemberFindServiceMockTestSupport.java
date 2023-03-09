package com.example.projecttest.test_4;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;


import com.example.projecttest.design.Member;
import com.example.projecttest.design.MemberFindService;
import com.example.projecttest.design.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class MemberFindServiceMockTestSupport extends MockTestSupport {

    // 외부 인프라
    @InjectMocks
    private MemberFindService memberFindService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    void mock_test() {
        //given
        final Member member = new Member("yun");

        given(memberRepository.findByName("yun"))
                .willReturn(member);

        //when
        final Member findMember = memberFindService.findByName("yun");

        //then
        then(findMember.getName())
                .isEqualTo("yun");
    }
}