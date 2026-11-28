package com.mky.springbootmky;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * {@link MemberRepository}의 학습 테스트.
 *
 * <p>학습 테스트는 기능 구현을 검증하기 위한 테스트가 아니라,
 * 우리가 사용하는 라이브러리·프레임워크가 지원하는 기능을 검증하며
 * 그 기능이 어떻게 동작하는지 파악하기 위한 테스트다.
 *
 * <p>이 클래스에서는 테스트 코드를 작성하며 JPA 메서드의 사용법을 익힌다.
 */
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    // Sql 어노테이션으로 테스트 실행 전에 SQL 스크립트를 실행시킬 수 있다.
    @Sql("/insert-members.sql")
    @Test
    void getAllMembers() {
        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberById() {

        //when
        Member member = memberRepository.findById(2L).get();

        //then
        assertThat(member.getName()).isEqualTo("B");
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName() {
        //when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }
}