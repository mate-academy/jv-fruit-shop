package fruitshop.strategy.operation.handlers.impl;

import fruitshop.strategy.operation.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer handle(Integer prevQuantity, Integer quantity) {
        return prevQuantity - quantity;
    }
}
