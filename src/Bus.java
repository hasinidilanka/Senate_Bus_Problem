
public class Bus extends Thread{

    private String busID;

    public Bus (String busID) {
        this.busID=busID;
        this.setName(busID);
        System.out.println("Bus "+busID+" has been created.");
    }

    public void run() {

            try {
                Main.mutex.acquire();

                if (Main.count >0){
                    Main.riders = Math.min(50, Main.count);
                    System.out.println(Main.riders+ " riders are waiting for a bus.");
                    System.out.println("Bus "+Thread.currentThread().getName()+" has arrived.");
                    Main.bus.release();
                    System.out.println("Bus "+Thread.currentThread().getName()+" is waiting for riders to all aboard.");
                    Main.allAboard.acquire();
                }
                Main.mutex.release();
                depart(Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



    }

    private void depart(String busID) {
        System.out.println("Bus "+busID+" is departing");
    }

}
