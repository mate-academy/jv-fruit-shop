package core.basesyntax.strategy;

public interface OperationStrategy {
    Transaction get(String operationType);
}
