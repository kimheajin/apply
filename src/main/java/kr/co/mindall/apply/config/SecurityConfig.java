package kr.co.mindall.apply.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf().disable()// csrf사용안함
			.headers()
				//.frameOptions().sameOrigin() // 동일 도메인 iframe허용
			.and() // 그리고
				.authorizeRequests() // 인증요청시
				.antMatchers("/","dashboard").permitAll() // 설정 주소 접근 모두 허용
				.anyRequest().authenticated() // 그 외의 요청 인증 필요
			.and()
				.formLogin()
				.loginPage("/")
				.loginProcessingUrl("/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true);
		return http.build();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.withUsername("user")
//								.password("password")
//								.roles("USER")
//								.build();
//		return new InMemoryUserDetailsManager(user);
//	}
}

