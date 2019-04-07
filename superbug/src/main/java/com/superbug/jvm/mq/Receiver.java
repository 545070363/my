package com.superbug.jvm.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class Receiver {

    @RabbitListener(queues = "queue1")
    public void process(byte[] msg) throws UnsupportedEncodingException {
        System.out.println("receiver:" + new String(msg,"UTF-8"));
    }
}
