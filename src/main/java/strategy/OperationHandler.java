package strategy;

import dto.ShopOperation;

public interface OperationHandler {
    int apply(ShopOperation shopOperation);
}
