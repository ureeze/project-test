package com.example.projecttest.test_4;

import static org.assertj.core.api.BDDAssertions.then;
import java.util.List;

import com.example.projecttest.design.Member;
import com.example.projecttest.design.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.jdbc.Sql;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@DataJpaTest
public class RepositoryTest {

    private final MemberRepository memberRepository;

    public RepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    public void member_test() {
        //given
        memberRepository.save(new Member("yun"));

        //when
        final Member findMember = memberRepository.findByName("yun");

        //then
        then(findMember.getName()).isEqualTo("yun");
    }

    @Test
    @Sql("/member-set-up.sql")
    public void sql_test() {
        final List<Member> members = memberRepository.findAll();
        then(members).hasSize(7);
    }
}