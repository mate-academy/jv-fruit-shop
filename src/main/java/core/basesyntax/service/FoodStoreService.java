package core.basesyntax.service;

import core.basesyntax.model.FruitTransactions;
import java.util.List;

public interface FoodStoreService {
    void processTransactions(List<FruitTransactions> fruitTransactionsList);
}
