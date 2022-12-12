package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void transfer(List<FruitTransaction> fruitTransactions);
}
