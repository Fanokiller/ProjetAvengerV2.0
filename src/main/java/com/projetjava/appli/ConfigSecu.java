package com.projetjava.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfigSecu extends WebSecurityConfigurerAdapter {

        @Autowired
        IdentificationDetailService identificationDetailService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.identificationDetailsService(identificationDetailService);
        }

}
