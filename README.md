Spring Boot. RabbitMQ. Sender/Receiver

run docker-compose.yml before launching app

UI RabbitMQ: http://localhost:15672/

user: guest

pass: guest

1. run sender app

2. run receiver app

send message to: http://localhost:8080/amqp/send?exchangeName=exchangeTest&routingKey=routingKeyTest&messageData=ms
