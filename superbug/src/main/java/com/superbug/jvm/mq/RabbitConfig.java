package com.superbug.jvm.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue getQueue(){
        Map<String,Object> param = new HashMap(){{
            put("x-message-ttl",600000);
        }};
        return new Queue("queue1",false,false,false,param);
    }

    @Bean
    public DirectExchange getExchange(){
        return new DirectExchange("ex1",false,false,null);
    }

    @Bean
    public Binding getBinding(){
        return BindingBuilder.bind(getQueue()).to(getExchange()).with("key1");
    }
}
