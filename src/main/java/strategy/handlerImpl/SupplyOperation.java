package strategy.handlerImpl;

import strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        return order + inStock;
    }
}
