package com.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService  userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/registration/**").permitAll().
		antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").
			and().
		formLogin().  //login configuration
            loginPage("/customLogin.jsp").
            failureUrl("/customLogin.jsp?failed=true").
            loginProcessingUrl("/appLogin").
            usernameParameter("app_username").
            passwordParameter("app_password").
            defaultSuccessUrl("/secure/home").	
            and().
        logout().    //logout configuration
			logoutUrl("/appLogout"). 
			logoutSuccessUrl("/customLogin.jsp");
	} 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN");
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder()); 
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		return encoder;
	}
} 