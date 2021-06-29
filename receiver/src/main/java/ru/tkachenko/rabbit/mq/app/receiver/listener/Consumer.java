package ru.tkachenko.rabbit.mq.app.receiver.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.tkachenko.rabbit.mq.app.common.model.TestRequest;
import ru.tkachenko.rabbit.mq.app.common.model.TestResponse;

/**
 * @author d.tkachenko
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

    @RabbitListener(queues = "#{appRabbitProperties.queueName}", concurrency = "3")
    public TestResponse receive(TestRequest testRequest) {
        log.info("receiver listener: {}", testRequest);
        return new TestResponse(testRequest.getName());
    }

}
