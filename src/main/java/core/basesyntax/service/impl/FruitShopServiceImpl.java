package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Storage storage;

    public FruitShopServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            storage.update(transaction.getFruit(), transaction.getQuantity(),
                    transaction.getOperation());
        }
        return storage.getFruitQuantities();
    }
}
