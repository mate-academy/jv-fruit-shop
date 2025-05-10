package core.basesyntax.service.action;

public interface ActionHandler {
    void count(String fruit, int amount);

    default void checkAmount(int amount) {
        if (amount < 0) {
            throw new RuntimeException("You can not add negative amount of fruit"
                    + ", please change your report");
        }
    }
}
