package com.parkingbooking.parkingbookingv1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.parkingbooking.parkingbookingv1.security.CustomAccessDeniedHandler;
import com.parkingbooking.parkingbookingv1.security.CustomAuthenticationFailureHandler;
import com.parkingbooking.parkingbookingv1.security.CustomLogoutSuccessHandler;
import com.parkingbooking.parkingbookingv1.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
    	 http
    	 .authorizeRequests()
    	 .antMatchers("/user").hasRole("USER")
    	 .antMatchers("/admin").hasRole("ADMIN")
    	 .anyRequest()
    	 .authenticated()
         .and()
         .formLogin();
    	 
    	 http.csrf().disable();
    	 http.headers().frameOptions().disable();
    	// @formatter:on
		// http.csrf().ignoringAntMatchers("/h2-console/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off		 
    	auth.
    	userDetailsService(customUserDetailService).
    	passwordEncoder(passwordEncoder());
//    	auth .inMemoryAuthentication() 
//          .withUser("user")
//          .password(this.passwordEncoder().encode("user"))
//          .roles("USER")
//          .and()
//          .withUser("admin")
//          .password(this.passwordEncoder().encode("admin"))
//          .roles("ADMIN");
    	// @formatter:on
	}


//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		// @formatter:off
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/anonymous*").anonymous()
//                .antMatchers("/login*").permitAll()
//                .antMatchers("/hello").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                //.failureUrl("/login.html?error=true")
//                .failureHandler(authenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(logoutSuccessHandler());
//        //.and()
//        //.exceptionHandling().accessDeniedPage("/accessDenied");
//        //.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
//        // @formatter:on
//	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}