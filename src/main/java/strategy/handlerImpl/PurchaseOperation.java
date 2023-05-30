package strategy.handlerImpl;

import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer operate(Integer order, Integer inStock) {
        if (order > inStock) {
            throw new RuntimeException((inStock - order) + "Fruits not enough");
        }
        return inStock - order;
    }
}
