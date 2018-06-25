package com.pgy.topic;

import com.pgy.fanout.FanoutSend;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@SpringBootConfiguration
public class TopicConfig {
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topicQueue2");
    }

    @Bean
    public Binding binding1(TopicExchange topic, Queue topicQueue1) {
        return BindingBuilder.bind(topicQueue1).to(topic).with("hello*");
    }

    @Bean
    public Binding binding2(TopicExchange topic, Queue topicQueue2) {
        return BindingBuilder.bind(topicQueue2).to(topic).with("hello#");
    }

    @Bean
    public TopicReceive receiver() {
        return new TopicReceive();
    }

    @Bean
    public FanoutSend send() {
        return new FanoutSend();
    }

}
