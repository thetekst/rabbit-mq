package ru.tkachenko.rabbit.mq.app.common.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author d.tkachenko
 */
@Data
@Validated
@ConfigurationProperties("app.rabbit")
public class AppRabbitProperties {

    @NotEmpty
    private String queueName;

    @NotEmpty
    private String exchange;

    @NotEmpty
    private String routingKey;

}
