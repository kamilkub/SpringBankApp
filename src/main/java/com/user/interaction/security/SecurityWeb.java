package com.user.interaction.security;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityWeb extends WebSecurityConfigurerAdapter {
    
	
    @Autowired
    DataSource dataSource;
	
   
     
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication()
	  .usersByUsernameQuery("select login, password, activated from users where login=?")
	  .authoritiesByUsernameQuery("select login, 'ROLE_USER' from users where login=?")
	    .dataSource(dataSource)
	    .passwordEncoder(passwordEncoder());
	
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();

		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/users/*").permitAll()
		    .antMatchers("/user/*").permitAll()
		    .antMatchers("/menu").hasAuthority("ROLE_USER")
		    .antMatchers("/menu/make/*").hasAuthority("ROLE_USER")
		    .antMatchers("/menu/*").authenticated()
		    .and()
		    .logout().permitAll()
		    .and().formLogin().loginPage("/user/login").permitAll()
		    .defaultSuccessUrl("/menu")
		    .usernameParameter("login")
		    .passwordParameter("password")
		    .loginProcessingUrl("/user/login").and()
		    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/user/login?logout").deleteCookies("remember-me")
		    .permitAll()
		    .and()
		    .rememberMe();
	}
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	
	
	
	
	
	
}
