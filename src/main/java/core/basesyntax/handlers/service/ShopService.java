package core.basesyntax.handlers.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);
}
