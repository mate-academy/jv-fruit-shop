package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StockService {
    void calculateStock(List<FruitTransaction> fruitTransactions);
}
