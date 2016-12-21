package si.fri.exercise.restservices.v1.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import si.fri.exercise.mediations.WeatherServiceAggregator;
import si.fri.exercise.models.Weather;

@RequestScoped
@Path("weather")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestServiceResource {

	@Inject
    private WeatherServiceAggregator weatherServiceAggregator;


    @GET
    public Response getWeather(){

        List<Weather> weather = weatherServiceAggregator.getAggregatedReport();


        return Response.ok().entity(weather).build();

    }
	
}
