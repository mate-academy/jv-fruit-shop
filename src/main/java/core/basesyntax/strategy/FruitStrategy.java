package core.basesyntax.strategy;

public interface FruitStrategy {
    OperationHandler getByOperation(String operation);
}
