package edu.du.sb1022secu3.controller;

import edu.du.sb1022secu3.entity.Member;
import edu.du.sb1022secu3.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Controller
public class BeginController {


    private final MemberRepository memberRepository;

    public BeginController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String index() {
        return "/sample/all";
    }

    @PostConstruct
    public void init() {
        Member member = Member.builder()
                .id(1001L)
                .username("hong1")
                .password(passwordEncoder().encode("1234"))
                .email("hong@aaa.com")
                .role("USER")
                .build();
        Member admin = Member.builder()
                .id(1000L)
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .email("admin@aaa.com")
                .role("ADMIN")
                .build();
        memberRepository.save(admin);
        memberRepository.save(member);
    }

    private PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
}
