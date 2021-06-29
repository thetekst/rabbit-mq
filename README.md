Spring Boot. RabbitMQ. Sender/Receiver

run docker-compose.yml before launching app

UI RabbitMQ: http://localhost:15672/

user: guest

pass: guest

run sender app
run receiver app

send message to: http://localhost:8080/amqp/send?exchangeName=e1&routingKey=rk1&messageData=ms
