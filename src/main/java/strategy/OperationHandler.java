package strategy;

import dto.ShopOperation;

public interface OperationHandler {
    void apply(ShopOperation shopOperation);
}
