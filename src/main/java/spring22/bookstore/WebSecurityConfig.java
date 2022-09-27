package spring22.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import spring22.bookstore.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig{
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	//https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		return http.authorizeRequests(auth -> {
			auth.antMatchers("/css/**").permitAll();
			// hasRole is not working with H2
			// auth.antMatchers("/owners/**").hasRole("ADMIN"); // ApplicationUsers??
			// if user's role is ADMIN s/he as access to all pages "under" owners
			auth.antMatchers("/admins/**").hasAuthority("ADMIN");
			// avery request will be authenticated
			auth.anyRequest().authenticated();
			
		})		// tells where to go after successfull login
				.formLogin().defaultSuccessUrl("/booklist", true).and()
				// logout is permitted for all users
				.logout().permitAll().and()
				.httpBasic(Customizer.withDefaults()).build();	
	}
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}

	
}
