package strategy.handlerimpl;

import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        return order + inStock;
    }
}
