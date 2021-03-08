package org.springboot.jpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		 UserDetails user1 = User.withUsername("maheedhar").password(getPasswordEncoder().encode("secret")).authorities("admin").build();
		 UserDetails user2 = User.withUsername("user").password(getPasswordEncoder().encode("password")).authorities("user").build();
		 userDetailsManager.createUser(user1);
		 userDetailsManager.createUser(user2);
		 auth.userDetailsService(userDetailsManager);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
