import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.Random;

public class JMSQueueExample {
    public static void main(String[] args) throws JMSException {
        // Create a connection factory
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create a connection
        Connection connection = factory.createConnection();
        connection.start();

        // Create a session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a queue
        Queue queue = session.createQueue("ExampleQueue");

        // Create a producer
        MessageProducer producer = session.createProducer(queue);
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            TextMessage message = session.createTextMessage("Hello World random id: " + random.nextLong());
            producer.send(message);
        }

        // Create a consumer
        MessageConsumer consumer = session.createConsumer(queue);
        while (true){
            Message receivedMessage = consumer.receive(100); // bail after 100 ms with no activity
            if (receivedMessage == null) {
                System.err.println("Received: " + receivedMessage + " no more messages to consume now");
                break;
            }
            else if (receivedMessage instanceof TextMessage) {
                System.out.println("Received: " + ((TextMessage) receivedMessage).getText());
            }
        }

        // Close resources
        session.close();
        connection.close();
    }
}