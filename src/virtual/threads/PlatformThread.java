package virtual.threads;

/**
 * Virtual threads: lightweight with minimal overhead( they are managed by JVM), simpler and more scalable
 * Platform threads:  traditional threads, directly mapped to the OS's native threads(managed by OS), resource intensive
 *
 *
 */
public class PlatformThread {

    static void main() {
        Thread threadPlat = new Thread("name") {
            @Override
            public void run() {
                System.out.println("Hello from " + getName());
            }
        };

        threadPlat.start();
    }
}
