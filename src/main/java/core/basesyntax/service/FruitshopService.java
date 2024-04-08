package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitshopService {
    void processData(List<FruitTransaction> fruitTransactionList);
}
