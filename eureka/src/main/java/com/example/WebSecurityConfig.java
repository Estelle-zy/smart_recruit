package com.example;

/**
 * @Author
 * @Date 2022/5/24 21:48
 * @Version 1.0
 * @Description
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
