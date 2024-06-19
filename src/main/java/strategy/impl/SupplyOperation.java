package strategy.impl;

import strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public int apply(int quantity) {
        return quantity;
    }
}
