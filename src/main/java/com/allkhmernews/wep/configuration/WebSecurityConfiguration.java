/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allkhmernews.wep.configuration;

import static javafx.scene.input.KeyCode.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author MSI
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
   
    @Autowired
    private AuthenticationSuccessHandler successHandler;
//  
//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
        //auth.inMemoryAuthentication();
        
//      http.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//      
//       http.formLogin()
//			.loginPage("/login")
//			.usernameParameter("username")
//		.passwordParameter("password")
//			.successHandler(successHandler);
//        
//      http.exceptionHandling()
//			.authenticationEntryPoint(authenticationEntryPoint);
//        http.authorizeRequests().antMatchers("/index")
//             
//               .hasAnyRole("ROLE_admin").
//       antMatchers("/index").hasAnyRole("member","ROLE_admin");

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication() 
               .withUser("khy").password("010910651").roles("ADMIN");
   }

    @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
		.passwordParameter("password")
			.defaultSuccessUrl("/index.html", true);
    
    http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.authorizeRequests()
              .antMatchers("/index/**").hasAnyRole("ADMIN");
              
    }
    
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
//      
     

