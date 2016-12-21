package si.fri.exercise.mediations;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import si.fri.exercise.models.Weather;



public class WeatherServiceConsumer {



    private Client client;
    private WebTarget base;
    private WebTarget weatherService;




    public WeatherServiceConsumer(){
        this.client = ClientBuilder.newClient();
        this.base = client.target("http://opendata.si/vreme/");
        this.weatherService = base.path("report/");

    }


    public Weather getWeatherReport(double lat, double lon){


        WebTarget target = weatherService.queryParam("lat", lat).queryParam("lon", lon);
        Response response = target.request().get();

        Weather weather = response.readEntity(Weather.class);

        return weather;

    }












}
