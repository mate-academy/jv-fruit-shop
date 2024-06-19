package strategy.impl;

import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public int apply(int quantity) {
        return quantity;
    }
}
