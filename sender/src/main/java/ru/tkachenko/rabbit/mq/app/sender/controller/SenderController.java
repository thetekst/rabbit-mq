package ru.tkachenko.rabbit.mq.app.sender.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tkachenko.rabbit.mq.app.common.model.TestRequest;
import ru.tkachenko.rabbit.mq.app.common.model.TestResponse;

/**
 * @author d.tkachenko
 */
@Slf4j
@RestController
@RequestMapping("/amqp")
@RequiredArgsConstructor
public class SenderController {

    private final AmqpTemplate amqpTemplate;

    @GetMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public TestResponse producer(@RequestParam("exchangeName") String exchange,
                                 @RequestParam("routingKey") String routingKey,
                                 @RequestParam("messageData") String messageData) {

        log.info("before controller");
        final var result = amqpTemplate.convertSendAndReceiveAsType(
                exchange,
                routingKey,
                new TestRequest(messageData),
                new ParameterizedTypeReference<TestResponse>() {}
        );
        log.info("result: {}", result);
        return result;
    }

}
