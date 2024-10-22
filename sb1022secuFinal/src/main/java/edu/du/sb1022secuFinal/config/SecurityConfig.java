package edu.du.sb1022secuFinal.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Log4j2
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        // 암호화하는 기법 객체
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Builder 패턴, 사용자를 등록
//        UserDetails user = User.withUsername("user")
//                // user의 비밀번호 '1234'를 암호화하여 설정한다.
//                .password(passwordEncoder().encode("1234"))
//                // 권한
//                .roles("ADMIN").roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("--------fiterChain----------");
        http.authorizeHttpRequests()
//                .antMatchers("/**").denyAll()
//                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/admin").hasRole("ADMIN")
                .anyRequest().authenticated();
        http.formLogin();
        http.csrf().disable();
        http.logout();
        http.exceptionHandling().accessDeniedPage("/sample/accessDenied");

        // 이 h2 데이터베이스를 admin role만 접근 가능하게 가능한가??
        // 근데 이게 맞나ㅡ ?
        http.csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin();
        return http.build();
    }
}
