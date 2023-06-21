package fruit.shop.service;

import fruit.shop.model.FruitTransaction;

import java.util.List;

public interface TransactionHandler {
    void parseStorage(List<FruitTransaction> transactions);
}
