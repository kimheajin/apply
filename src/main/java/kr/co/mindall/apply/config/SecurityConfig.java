package kr.co.mindall.apply.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
//			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())// 기본옵션인 csrf방어 사용안함
//			.and()
			.authorizeRequests() // 페이지 권한 부여. antMatchers기능 사용에 필요한 메소드
			.antMatchers("/login/**").authenticated() // 해당 URL접근 시에는 인가를 필요로 한다고 명시.
			.antMatchers("/dashboard/**").access("ROLE_ADMIN") // 해당 URL접근 시에는 인가를 필요로 한다고 명시. access는 접근가능한 role
			.anyRequest().permitAll() // 특정 URL을 제외하면 모두 인가
			.and() // 그리고
				.formLogin() // 폼으로 로그인 할 경우
				.loginPage("/login").permitAll() // 로그인 페이지 설정
				.loginProcessingUrl("/loginProcess") // form action
				.usernameParameter("id") // form의 id
				.passwordParameter("password") // form의 password
				.defaultSuccessUrl("/") // 성공 시 해당 url로 이동
			.and()
				.logout()
				.logoutUrl("/logolut")
				.logoutSuccessUrl("/"); // 로그아웃 성공 시 해당 url로 이동
		return http.build();
	}
	
}

