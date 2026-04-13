package virtual.threads;

/**
 * Virtual threads are suitable for running tasks that spend most of the time blocked, often waiting for I/O operations to complete.
 * However, they aren't intended for long-running CPU-intensive operations.
 * Virtual threads are not faster threads; they do not run code any faster than platform threads.
 * They exist to provide scale (higher throughput), not speed (lower latency).
 */

import java.util.concurrent.TimeUnit;

public class VirtualThread implements Runnable{

    static void main() {
        long start = System.currentTimeMillis();
        Runnable runnable = () -> {
        };

        for (int i = 0; i < 50000; i++ ) {
                Thread.startVirtualThread(runnable);
        }

        long finish = System.currentTimeMillis();
        long timeElapsed = finish  - start;
        System.out.println("Run time for virtual threads: " + (TimeUnit.MILLISECONDS.toSeconds(timeElapsed) == 0 ? timeElapsed + " miliseconds " : TimeUnit.MILLISECONDS.toSeconds(timeElapsed) + " seconds"));


        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++ ) {
            Thread thread = new Thread(runnable);
            thread.start();
        }


        finish = System.currentTimeMillis();
        timeElapsed = finish  - start;
        System.out.println("Run time for platform threads: " + (TimeUnit.MILLISECONDS.toSeconds(timeElapsed) == 0 ? timeElapsed + " miliseconds " : TimeUnit.MILLISECONDS.toSeconds(timeElapsed) + " seconds"));
    }


    @Override
    public void run() {
        System.out.println("Hello from  " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
