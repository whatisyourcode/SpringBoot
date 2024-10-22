package edu.du.sb1021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // BCryptPasswordEncoder 객체를 생성하여 비밀번호를 암호화하는 데 사용합니다.
        // BCrypt는 보안성이 높은 해시 함수로, 저장된 비밀번호를 안전하게 보호할 수 있도록 도와줍니다.
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user1")
                .password(passwordEncoder().encode("1234"))
                // 비밀번호를 "1234"로 설정하고, 이를 passwordEncoder() 메서드를 사용해 BCrypt 방식으로 암호화합니다.
                .roles("USER")
                // 이 사용자의 역할을 "USER"로 지정합니다. 이는 권한과 관련된 설정입니다.
                .build();
                // 설정된 정보를 바탕으로 UserDetails 객체를 생성합니다.

        return new InMemoryUserDetailsManager(user);
        // 생성된 사용자 정보를 메모리에 저장하는 InMemoryUserDetailsManager를 반환합니다.
        // 이 UserDetailsService는 메모리에서 사용자 정보를 관리하며, 실제 데이터베이스를 사용하지 않습니다.
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() // HTTP 요청에 대한 권한 설정을 시작합니다.
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                // 위 경로에 대한 요청은 모든 사용자에게 허용됩니다.
                // 즉, 인증 없이 이 경로에 접근할 수 있습니다.
                .anyRequest().authenticated();
                // 그 외의 모든 요청은 인증이 필요하다는 규칙입니다.
               // "/sample/all" 외의 경로에 접근하려면 사용자가 반드시 로그인해야 합니다.

        http.formLogin();
        // 기본 제공되는 로그인 폼을 사용하여 사용자 인증을 처리합니다.
        // 사용자가 인증이 필요한 페이지에 접근할 때 자동으로 로그인 페이지가 제공됩니다.

        http.csrf().disable();

        return http.build();
        // 위의 보안 설정을 기반으로 SecurityFilterChain 객체를 생성하여 반환합니다.
    }
}
