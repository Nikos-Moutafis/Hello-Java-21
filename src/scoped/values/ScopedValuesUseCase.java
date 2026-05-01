package scoped.values;

public class ScopedValuesUseCase {

    static void main() throws InterruptedException {
        Thread.startVirtualThread( () -> {
            ScopedValue.runWhere(CurrentUser.USER, "VThread", () -> new TaskDefinition().runTaskDefinition());
        });
        Thread.sleep(1000);
    }
}


class CurrentUser {
    final static ScopedValue<String> USER =  ScopedValue.newInstance();

}

class TaskDefinition {

    public void runTaskDefinition() {
        Step step = new Step();
        step.runStep();
    }
}

class Step {
    void runStep() {
        System.out.println("Current user: " + CurrentUser.USER.get());
    }
}