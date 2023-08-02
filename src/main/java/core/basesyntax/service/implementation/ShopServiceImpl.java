package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.StoreOperationsHandler;

public class ShopServiceImpl implements ShopService {
    private Storage storage;

    public ShopServiceImpl() {
    }

    public ShopServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        StoreOperationsHandler handler
                = FruitTransaction.PROCESS_SELECTOR.get(transaction.getOperation());
        handler.applyOperation(storage, transaction.getFruit(), transaction.getQuantity());
    }
}
