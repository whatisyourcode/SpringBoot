package edu.du.sb10201_2;

import edu.du.sb10201_2.entity.Member;
import edu.du.sb10201_2.repository.MemberRepository;
import edu.du.sb10201_2.spring.MemberDao;
import edu.du.sb10201_2.spring.MemberRegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.Buffer;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Sb102012ApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberDao memberDao;

    @Test
    void 입력테스트() {
        Member member = Member.builder()
                .name("홍길동")
                .password("1234")
                .email("aaa@korea.com")
                .regdate(LocalDateTime.now())
                .build();
        System.out.println(memberRepository.save(member));

        Member members = memberDao.selectByEmail("aaa@korea.com");
        System.out.println(members);
    }

}
