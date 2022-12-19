package core.basesyntax.service;

import core.basesyntax.operations.OperationAction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    Map<FruitTransaction.Operation, OperationAction> operations;
    FruitTransaction fruitTransaction;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationAction> operations, FruitTransaction fruitTransaction){
        this.operations = operations;
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void getOperation(FruitTransaction.Operation operation) {
        operations.get(operation).makeShopOperation(fruitTransaction);

    }
}
