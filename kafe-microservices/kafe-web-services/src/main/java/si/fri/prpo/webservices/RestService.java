package si.fri.prpo.webservices;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.prpo.mediations.ServiceAggregator;
import si.fri.prpo.mediations.TrafficServiceAggregator;
import si.fri.prpo.models.Traffic;
import si.fri.prpo.models.Weather;

@RequestScoped
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestService {

	@Inject
    private ServiceAggregator serviceAggregator;
	@Inject
    private TrafficServiceAggregator trafficServiceAggregator;

    @GET
    @Path("weather")
    public Response getWeather(){
        List<Weather> weather = serviceAggregator.getAggregatedReport();
        return Response.ok().entity(weather).build();

    }
    
    @GET
    @Path("traffic")
    public Response getTraffic() {
    	List<Traffic> traffic = trafficServiceAggregator.getAggregatedReport();
    	
    	return Response.ok().entity(traffic).build();
    }
}
