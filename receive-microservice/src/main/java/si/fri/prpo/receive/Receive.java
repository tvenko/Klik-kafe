package si.fri.prpo.receive;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;



@ApplicationScoped
public class Receive {
	
	private static final String VRSTA = "vrsta";

	
	public void init( @Observes @Initialized( ApplicationScoped.class ) Object init ) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(VRSTA, false, false, false, null);
		
		Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String sporocilo = new String(body, "UTF-8");
                System.out.println(" [x] Prejeto sporocilo: '" + sporocilo + "'");
            }
        };
        channel.basicConsume(VRSTA, true, consumer);

    }
}
