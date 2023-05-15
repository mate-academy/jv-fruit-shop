package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopTransaction {
    void makeTransaction(List<FruitTransaction> transactions);
}
