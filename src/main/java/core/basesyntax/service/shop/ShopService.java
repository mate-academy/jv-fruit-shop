package core.basesyntax.service.shop;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions, Storage storage);
}
