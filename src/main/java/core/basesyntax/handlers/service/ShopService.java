package core.basesyntax.handlers.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.handlers.OperationStrategy;

import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);
}
