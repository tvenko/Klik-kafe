package si.fri.exercise.mediations;

import si.fri.exercise.models.Weather;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


@ApplicationScoped
public class WeatherServiceAggregator {


    public void init( @Observes @Initialized( ApplicationScoped.class ) Object init ) {

        initTimer();
    }

    public static final Logger LOG = Logger.getLogger(WeatherServiceAggregator.class.getName());

    private List<Weather> weatherList;




    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    private List<Weather> getWeatherList(){
        if(weatherList == null){
            weatherList = Collections.synchronizedList(new ArrayList<Weather>());
        }

        return weatherList;

    }

    private class MyRunnable implements Runnable{

        private double lat;
        private double lon;
        private List<Weather> weatherList;
        private WeatherServiceConsumer wsc;


        public MyRunnable(double lat, double lon, List<Weather> weatherList){
            this.lat = lat;
            this.lon = lon;
            this.weatherList = weatherList;
            wsc = new WeatherServiceConsumer();
        }


        public void run() {
            LOG.log(Level.INFO, "service called");
            Weather weather = wsc.getWeatherReport(lat, lon);

            weatherList.add(weather);
        }
    }

    public void initTimer() {

       MyRunnable runnable = new MyRunnable(46, 14.5, getWeatherList());

        final ScheduledFuture<?> runnableHandle =
                scheduler.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);

    }



    public List<Weather> getAggregatedReport(){

        // obdelaj vremenske podatke, npr. pripravi poročilo

        return getWeatherList();

    }




}
