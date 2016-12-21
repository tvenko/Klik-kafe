package si.fri.prpo.mediations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import si.fri.prpo.models.Traffic;

@ApplicationScoped
public class TrafficServiceAggregator {

    public void init( @Observes @Initialized( ApplicationScoped.class ) Object init ) {
        initTimer();
    }

    public static final Logger LOG = Logger.getLogger(ServiceAggregator.class.getName());
    private List<Traffic> trafficList;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private List<Traffic> getTrafficList(){
        if(trafficList == null){
            trafficList = Collections.synchronizedList(new ArrayList<Traffic>());
        }
        return trafficList;
    }

    private class MyRunnable implements Runnable{

        private List<Traffic> TrafficList;
        private TrafficServiceConsumer tsc;
        public MyRunnable(List<Traffic> TrafficList){
            this.TrafficList = TrafficList;
            tsc = new TrafficServiceConsumer();
        }

        public void run() {
            LOG.log(Level.INFO, "service called");
            Traffic traffic = tsc.getTrafficReport();

            TrafficList.add(traffic);
        }
    }

    public void initTimer() {
       MyRunnable runnable = new MyRunnable(getTrafficList());

       final ScheduledFuture<?> runnableHandle = scheduler.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);

    }

    public List<Traffic> getAggregatedReport(){

    	return getTrafficList();
    }





}
