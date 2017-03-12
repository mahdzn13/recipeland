package com.recipeland;

import com.recipeland.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//--- Ejemplo de bean ---//
/*
@Configuration
public class BeanConfig {


    @Bean
    @Scope(value = "prototype")
    public User user(){
        return new User("xaxo","Xavi", "xtorrens@recipeland.com");
    }

}
*/