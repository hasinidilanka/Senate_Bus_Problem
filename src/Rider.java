import java.util.concurrent.Semaphore;

public class Rider extends Thread {
    private int riderId;
    private int riderGenerateId;

    Rider(int id){
        this.riderGenerateId=id;
        System.out.println("Rider "+riderGenerateId+ " is created");
    }
    public void run(){
        try {
            Main.multiplex.acquire();
            Main.mutex.acquire();
            Main.count+=1;
            this.riderId=Main.count;
            System.out.println("Rider "+riderGenerateId+" came to the bus station. He is the "+riderId+ " rider in the station.");
            Main.mutex.release();

            Main.bus.acquire();
            Main.multiplex.release();

            boardBus();

            Main.riders-=1;
            Main.count-=1;
            if(Main.riders==0){
                System.out.println("Notify the bus to depart ");
                Main.allAboard.release();
            }else{
                Main.bus.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void boardBus(){
        System.out.println("Rider "+riderGenerateId+ " board to the bus");
    }
}
