package strategy.handlerImpl;

import strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        return order + inStock;
    }
}
