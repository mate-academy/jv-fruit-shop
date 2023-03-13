package core.basesyntax.service;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.strategy.OperatioHandlerStrategyImpl;

public class StorageServiceImpl implements StorageService {
    private final OperatioHandlerStrategyImpl handlerStrategy;

    public StorageServiceImpl(OperatioHandlerStrategyImpl handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (checkData(fruitTransaction)) {
            OperationHandler operationHandler =
                    handlerStrategy.chooseOperation(fruitTransaction.getTypeOperation());
            operationHandler.handle(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Wrong data");
        }
    }

    private boolean checkData(FruitTransaction fruitTransaction) {
        return fruitTransaction.getTypeOperation() != null
                && fruitTransaction.getFruit() != null
                && fruitTransaction.getQuantity() != null
                && !fruitTransaction.getFruit().isEmpty()
                && fruitTransaction.getQuantity() < Integer.MAX_VALUE >> 4;
    }
}
