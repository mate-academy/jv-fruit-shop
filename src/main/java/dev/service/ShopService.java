package dev.service;

import dev.repository.FruitStore;
import dev.transaction.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions, FruitStore repository);
}
