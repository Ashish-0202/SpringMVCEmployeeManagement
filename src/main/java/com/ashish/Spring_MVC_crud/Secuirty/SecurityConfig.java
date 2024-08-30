package com.ashish.Spring_MVC_crud.Secuirty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

   /* @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails ash= User.builder()
                .username("Ash2002")
                .password("{noop}Ashish2002")
                .roles("EMPLOYEE")
                .build();

        UserDetails Theju = User.builder()
                .username("thej12")
                .password("{noop}chid123")
                .roles("MANAGER","EMPLOYEE")
                .build();

        UserDetails john = User.builder()
                .username("john12")
                .password("{noop}password")
                .roles("MANAGER","EMPLOYEE","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ash,Theju,john);
    }*/
    //Default Schema based on jdbc user detail manager
   /* @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    //Custom Schema based on jdbc user detail manager
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Define query to find users by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("Select user_id,password,enabled from members where user_id=?");

        //Define query to fine roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("Select user_id,role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        security.authorizeHttpRequests(configure->
                configure
                        .requestMatchers("/employees/display").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers("/employees/manager").hasRole("MANAGER")
                        .requestMatchers("/employees/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form->
                        form.loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())
                .exceptionHandling(configure->
                        configure.accessDeniedPage("/accessDenied"))
                .logout(LogoutConfigurer::permitAll);

        return security.build();
    }
}
