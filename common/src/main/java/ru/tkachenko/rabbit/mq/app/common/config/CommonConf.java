package ru.tkachenko.rabbit.mq.app.common.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tkachenko.rabbit.mq.app.common.config.property.AppRabbitProperties;

/**
 * @author d.tkachenko
 */
@Configuration
public class CommonConf {

    @Bean
    public MessageConverter commonJsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AppRabbitProperties appRabbitProperties() {
        return new AppRabbitProperties();
    }

    @Bean
    public AmqpTemplate amqpTemplate(final ConnectionFactory connectionFactory,
                                           final MessageConverter commonJsonMessageConverter) {

        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(commonJsonMessageConverter);
        return rabbitTemplate;
    }

    @Bean
    DirectExchange messagesExchange(final AppRabbitProperties appRabbitProperties) {
        return new DirectExchange(appRabbitProperties.getExchange());
    }

    @Bean
    Queue messagesQueue(final AppRabbitProperties appRabbitProperties) {
        return new Queue(appRabbitProperties.getQueueName(), false);
    }

    @Bean
    Binding messagesBinding(final AppRabbitProperties appRabbitProperties,
                            final Queue messagesQueue,
                            final DirectExchange messagesExchange) {

        return BindingBuilder
                .bind(messagesQueue)
                .to(messagesExchange)
                .with(appRabbitProperties.getRoutingKey());
    }

}
