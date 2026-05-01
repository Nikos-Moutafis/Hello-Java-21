package scoped.values;

/**
 * This is a preview feature in JDK.
 * Scoped values are used to share and store immutable data among threads
 * They are immutable
 */
public class ScopedValues {

    static void main() throws InterruptedException {
        ScopedValue.runWhere(TaskOne.VALUE, "Hello World from regular thread", () -> {
            new TaskOne().doTask();
        });


        Thread.startVirtualThread(() -> ScopedValue.runWhere(
                TaskOne.VALUE, "Hello from VThread", () -> new TaskOne().doTask()));

        Thread.sleep(1000);
    }
}

class TaskOne {
    final static ScopedValue<String> VALUE =  ScopedValue.newInstance();

    void doTask() {
        System.out.println("Task: " + VALUE.get());
    }
}