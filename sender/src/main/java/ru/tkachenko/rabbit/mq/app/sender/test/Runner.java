package ru.tkachenko.rabbit.mq.app.sender.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.tkachenko.rabbit.mq.app.common.config.property.AppRabbitProperties;

/**
 * @author d.tkachenko
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final AmqpTemplate amqpTemplate;

    private final AppRabbitProperties appRabbitProperties;

    @Override
    public void run(String... args) throws Exception {
//        amqpTemplate.convertAndSend(senderRabbitProperties.getExchange(), senderRabbitProperties.getRoutingKey(), "Hello from RabbitMQ!");
    }

}
