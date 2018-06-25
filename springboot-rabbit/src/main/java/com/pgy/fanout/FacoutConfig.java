package com.pgy.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@SpringBootConfiguration
public class FacoutConfig {
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("tut.fanout");
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2");
    }

    @Bean
    public Binding binding1(FanoutExchange fanout, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanout);
    }

    @Bean
    public Binding binding2(FanoutExchange fanout, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanout);
    }

    @Bean
    public FanoutReceiver receiver() {
        return new FanoutReceiver();
    }

    @Bean
    public FanoutSend send() {
        return new FanoutSend();
    }

}
