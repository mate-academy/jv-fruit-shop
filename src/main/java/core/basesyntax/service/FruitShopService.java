package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void processTransactions(List<FruitTransaction> fruitTransactionList);
}