package fruitshop.strategy.operation.handlers.impl;

import fruitshop.strategy.operation.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer handle(Integer prevQuantity, Integer quantity) {
        return prevQuantity + quantity;
    }
}
