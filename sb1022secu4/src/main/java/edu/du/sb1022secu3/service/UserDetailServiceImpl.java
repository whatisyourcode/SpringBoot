package edu.du.sb1022secu3.service;


import edu.du.sb1022secu3.entity.Member;
import edu.du.sb1022secu3.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("===========> 사용자: " +username);
        Member member = memberRepository.findByUsername(username);
//        if(member.getUsername() == "admin"){
//            return toUserDetailsAdmin(member);
//        }

//        UserDetails user = User.withUsername("user")
//                // user의 비밀번호 '1234'를 암호화하여 설정한다.
//                .password(passwordEncoder().encode("1234"))
//                // 권한
//                .roles("ADMIN")
//                .build();
//        return user;




//        Member member = Member.builder()
//                .id(1001L)
//                .username("홍길동")
//                .password(passwordEncoder().encode("1234"))
//                .email("hong@aaa.com")
//                .build();
        return toUserDetails(member);

    }


    private PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    // 로그인 과정 중 로그인 정보를 가져와서 ROLE 권한을 부여하여 빌드하는 방식.
    // USER ROLE 은 일반 사용자 권한
    private UserDetails toUserDetails(Member member) {
        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
//                .authorities(new SimpleGrantedAuthority(member.getRole().toString()))
                .roles(member.getRole())
                .build();
    }

//    private UserDetails toUserDetailsAdmin(Member member) {
//        return User.builder()
//                .username(member.getUsername())
//                .password(member.getPassword())
//       //         .authorities(new SimpleGrantedAuthority(member.getRole().toString()))
//                .roles("ADMIN")
//                .build();
//    }
}
