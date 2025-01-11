package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ShopService;
import core.basesyntax.storage.Storage;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private Storage storage;

    public ShopServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void operations(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fr : fruitTransactions) {
            storage.put(fr.getFruit(), fr.getQuantity());
        }
    }
}
