package si.fri.prpo.send.rest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import si.fri.prpo.send.Sporocilo;

@Path("/vrsta")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SendREST {
	
	private static final String VRSTA = "vrsta";
	@POST
	public Response sendMessage(Sporocilo sporocilo) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(VRSTA, false, false, false, null);
        channel.basicPublish("", VRSTA, null, sporocilo.getString().getBytes());
		return Response.ok().build();
	}
}
