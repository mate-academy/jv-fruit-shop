package core.basesyntax.service;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessFruitShopStorage {
    public FruitShopStorage fillFruitShopStorage(List<FruitTransaction> fruitTransactionList);
}
