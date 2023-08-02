package core.basesyntax.service.impl;

import core.basesyntax.handler.OrderReturnHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationServiceImpl implements OperationHandler {
    private final OrderReturnHandler orderReturnHandler;

    public ReturnOperationServiceImpl(OrderReturnHandler orderReturnHandler) {
        this.orderReturnHandler = orderReturnHandler;
    }

    @Override
    public boolean applyOperation(FruitTransaction fruitTransaction) {
        return orderReturnHandler.returnOrder(fruitTransaction.getFruitName(),
                fruitTransaction.getFruitQuantity());
    }
}
