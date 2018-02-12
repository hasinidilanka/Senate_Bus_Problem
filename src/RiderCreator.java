import java.util.Random;

public class RiderCreator extends Thread {
    private int meanTime=30;
    private int riderId=0;
    public double waitingTimeCreator(double time){
        Random rand = new Random();
        return Math.log(1-rand.nextDouble())*(-time);
    }
    public void run(){
        while(true){
            riderId+=1;
            Rider rider = new Rider(riderId);
            double waitingTime=waitingTimeCreator(meanTime);
            try {
                if(riderId==1){
                    rider.start();
                }
                else{
                    Thread.sleep((long)waitingTime*1000);
                    rider.start();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



}
