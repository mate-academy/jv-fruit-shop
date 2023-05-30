package strategy.handlerimpl;

import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        return inStock;
    }
}
