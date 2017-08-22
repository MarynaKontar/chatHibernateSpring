package ua.goit.offline.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.offline.service.UserDetailsServiceImpl;
import ua.goit.offline.service.UserService;

/**
 * Created by User on 14.08.2017.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new UserDetailsServiceImpl(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .mvcMatchers("/*")//только какие-то пути проверяются на пароль и пользователя
                .antMatchers("/registration","/login").not().authenticated()
                .anyRequest()
                .authenticated()//хотим чтобі все user-ов проверяли
                .and()
                .formLogin()//базовая форма на логин пароль будет выпадать
//        .and().httpBasic()//можно другую форму использовать
                .and().csrf().disable();
    }
}
