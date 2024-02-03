package core.basesyntax.service.strategy;

public interface OperationStrategy {
    int apply(int balanceValue, int valueToChangeBalance);
}
