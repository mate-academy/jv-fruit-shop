package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ShopService;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private Storage storage;

    public ShopServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operations(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> storage1 = storage.getStorage();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            storage1.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
