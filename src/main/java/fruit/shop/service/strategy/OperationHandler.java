package fruit.shop.service.strategy;

import fruit.shop.model.FruitTransaction;

public interface OperationHandler {
    void getOptionResult(FruitTransaction transaction);
}
