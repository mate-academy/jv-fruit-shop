package core.basesyntax.strategy;

public interface OperationStrategy {
    void execute(String fruit, int quantity);

    boolean isValid(String fruit, int quantity);
}
