package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void execute(List<FruitTransaction> fruitTransactions);
}

