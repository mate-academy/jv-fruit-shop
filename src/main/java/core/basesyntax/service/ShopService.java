package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);

    Storage getStorage();
}
