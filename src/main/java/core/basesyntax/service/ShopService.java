package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    public Storage process(List<FruitTransaction> transactions);
}
