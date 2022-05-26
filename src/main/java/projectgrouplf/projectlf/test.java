package projectgrouplf.projectlf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test {

    public static int i = 0;
    public static boolean goOn = true;
    public static void main(String[] args) {


        Runnable helloRunnable = new Runnable() {
            public void run() {
                System.out.println(i++);
            }       
        };   
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }
    
}