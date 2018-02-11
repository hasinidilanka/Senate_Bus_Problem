import java.util.Random;

public class BusCreator {

    private int meanInterArrivalTime = 12;

    private int busCounter =0;

    private double nextBusArrivalTime(double d){
        Random r = new Random();
        return  Math.log(1-r.nextDouble())*(-d);
    }

    public void create(){
        while(true) {
            Bus bus = new Bus(Integer.toString(busCounter));
            double startTime = nextBusArrivalTime(meanInterArrivalTime);

            if (busCounter ==0) {
//                System.out.println("Bus "+busCounter+" started now");
                bus.start();
                busCounter++;

            } else {
                try {
//                    System.out.println("Bus "+busCounter+" will start after "+startTime+" seconds.");
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
