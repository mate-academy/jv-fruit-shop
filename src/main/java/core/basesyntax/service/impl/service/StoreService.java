package core.basesyntax.service.impl.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StoreService {
    List<Integer> getOperationsAmount(List<FruitTransaction> fruitTransactionList);

    List<String> getFruitList(List<FruitTransaction> fruitTransactionList);
}
