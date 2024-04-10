package fruit.shop.service.transaction;

import fruit.shop.model.FruitTransaction;

public interface TransactionHandler {
    void execute(FruitTransaction transaction);
}
