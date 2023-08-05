package core.service;

import core.model.FruitTransaction;

import java.util.List;

public interface FruitShopService {
    void processTransactions(List<FruitTransaction> transactions);
}
