package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface FruitShopService {
    void transactionProcess(List<FruitTransaction> fruitTransactionList);
}
