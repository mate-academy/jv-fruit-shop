package core.basesyntax.strategy;

public interface OperationStrategy {

    //todo: operation may be in fruit transaction()
    OperationProcessor get(FruitTransaction.Operation operation);
}
