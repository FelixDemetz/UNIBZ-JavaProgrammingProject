package projectgrouplf.projectlf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test {

    public static int i = 0;
    public static boolean goOn = true;
    public static void main(String[] args) throws InterruptedException {

        while (goOn) {
            long millis = System.currentTimeMillis();
            System.out.println(i++);
            Thread.sleep(1000 - millis % 1000);
        }

        Runnable helloRunnable = new Runnable() {
            public void run() {
                System.out.println(i++);
            }       
        };   
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }
    
}
