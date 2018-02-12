import java.util.Random;

public class BusCreator extends Thread {

    private int meanInterArrivalTime = 1200;

    private int busCounter =0;

    private double nextBusArrivalTime(double d){
        Random r = new Random();
        return  Math.log(1-r.nextDouble())*(-d);
    }

    public void run(){
        while(true) {
            Bus bus = new Bus(Integer.toString(busCounter));
            double startTime = nextBusArrivalTime(meanInterArrivalTime);

            if (busCounter ==0) {
                bus.start();
                busCounter++;

            } else {
                try {
                    Thread.sleep((long)startTime*1000);
                    bus.start();
                    busCounter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }




}
