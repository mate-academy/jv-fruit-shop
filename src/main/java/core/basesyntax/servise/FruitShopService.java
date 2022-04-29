package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void apply(List<FruitTransaction> fruitTransactionList);
}
