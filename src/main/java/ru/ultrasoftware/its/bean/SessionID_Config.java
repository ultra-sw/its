package ru.ultrasoftware.its.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pwmn on 16/11/2017.
 */
@Configuration
public class SessionID_Config {
    @Bean
 public SessionID sessionID(){
        return new SessionID();
    }
}
