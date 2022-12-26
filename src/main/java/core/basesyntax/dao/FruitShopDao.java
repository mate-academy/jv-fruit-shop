package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopDao {
    List<FruitTransaction> parseTransactions(String dataFromFile);
}
