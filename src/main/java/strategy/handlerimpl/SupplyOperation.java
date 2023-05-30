package strategy.handlerimpl;

import strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        return order + inStock;
    }
}
