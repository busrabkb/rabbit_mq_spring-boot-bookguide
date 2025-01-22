# Spring Boot Microservice Example with RabbitMQ

This project demonstrates a simple microservice application using Spring Boot and RabbitMQ. The application allows you to send messages via a REST API and consume those messages from a RabbitMQ queue.

It also includes **Retry** and **Dead Letter Queue (DLQ)** mechanisms for handling failed messages.

## Prerequisites

Before running the project, ensure that you have the following installed:

- **Java Development Kit (JDK)**: 17 or higher
- **Maven**: 3.6 or higher
- **Docker and Docker Compose**: Installed and configured

## Setup and Run

### 1. Clone the Repository
Clone the project repository using the following command:
```bash
git clone <REPO_URL>
cd <REPO_NAME>
```

### 2. Start RabbitMQ Container
Use Docker Compose to start RabbitMQ:
```bash
docker-compose up -d
```
You can access the RabbitMQ management dashboard at [http://localhost:15672](http://localhost:15672). The default credentials are:
- Username: `guest`
- Password: `guest`

### 3. Build and Run the Project
Build and run the project using Maven:
```bash
mvn clean install
mvn spring-boot:run
```

### 4. Using the API
You can send messages to the RabbitMQ queue via the REST API.

#### Send a Message
```bash
POST /api/messages
Content-Type: application/json

{"message": "Hello RabbitMQ!"}
```

A successful request will return:
```json
{"message": "Message sent."}
```

## Retry and Dead Letter Queue (DLQ)

This project includes support for retrying failed messages and redirecting unprocessable messages to a Dead Letter Queue (DLQ).

### How It Works
- **Retry Mechanism**: If a consumer fails to process a message, the message will be retried a predefined number of times.
- **Dead Letter Queue**: If the message still cannot be processed after the retries, it will be sent to a separate Dead Letter Queue for further inspection or handling.

### Configuration
In the `RabbitMQConfig.java`, the following configurations are added:
- A DLQ queue (`deadLetterQueue`)
- A retry mechanism using RabbitMQ arguments

### Testing DLQ
To test the retry and DLQ:
1. Send a message to the main queue.
2. Simulate a failure in the consumer by throwing an exception.
3. Check the DLQ for the unprocessed message.

## Project Structure

- **RabbitMQConfig.java**: Configures the RabbitMQ queue, exchange, retry mechanism, and Dead Letter Queue.
- **MessageProducer.java**: Sends messages to the RabbitMQ queue.
- **MessageConsumer.java**: Listens to the queue and processes messages, including retry logic.
- **MessageController.java**: Provides REST API functionality.
- **docker-compose.yml**: Configures and starts the RabbitMQ container.

## Troubleshooting

1. **RabbitMQ Connection Issues**:
   - Ensure RabbitMQ is running.
   - Check the Docker container status:
     ```bash
     docker ps
     ```

2. **Connection Timeout**:
   - Verify that the RabbitMQ container is configured correctly in `docker-compose.yml`:
     ```yaml
     environment:
       RABBITMQ_DEFAULT_USER: guest
       RABBITMQ_DEFAULT_PASS: guest
     ports:
       - "5672:5672"
       - "15672:15672"
     ```

## Contributing
If you would like to contribute, please submit a pull request or open an issue.

## License
This project is licensed under the [MIT License](LICENSE).

