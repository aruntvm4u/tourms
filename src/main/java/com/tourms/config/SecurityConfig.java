package com.tourms.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Created by aruntvm4u on 2/13/2016.
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    @Qualifier("userDetailsService")
//    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
//            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
            auth.inMemoryAuthentication().withUser("friend").password("master").authorities("ROLE_ADMIN");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/")
//                .access("hasRole('ROLE_ADMIN')")
                .hasAnyRole()
                .and().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login?logout")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/403");

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(128);
        return encoder;
    }
}