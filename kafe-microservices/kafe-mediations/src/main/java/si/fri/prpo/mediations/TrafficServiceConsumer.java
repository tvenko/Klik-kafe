package si.fri.prpo.mediations;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import si.fri.prpo.models.Traffic;

public class TrafficServiceConsumer {
	private Client client;
    private WebTarget base;
    private WebTarget trafficService;

    public TrafficServiceConsumer(){
        this.client = ClientBuilder.newClient();
        this.base = client.target("http://opendata.si/promet/");
        this.trafficService = base.path("events/");
    }

    public Traffic getTrafficReport(){

        WebTarget target = trafficService;
        Response response = target.request().get();

        Traffic traffic = response.readEntity(Traffic.class);

        return traffic;
    }
}
