package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FoodStoreService {
    void processTransactions(List<FruitTransaction> fruitTransactionsList);
}
