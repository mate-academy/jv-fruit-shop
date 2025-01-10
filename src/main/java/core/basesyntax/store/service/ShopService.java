package core.basesyntax.store.service;

import core.basesyntax.store.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
