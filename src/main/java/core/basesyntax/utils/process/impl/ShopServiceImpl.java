package core.basesyntax.utils.process.impl;

import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.process.ShopService;
import core.basesyntax.utils.transaction.FruitTransaction;
import core.basesyntax.utils.transaction.handlers.OperationHandlerFactory;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationHandlerFactory factory;
    private final StorageImpl storage;

    public ShopServiceImpl(OperationHandlerFactory factory, StorageImpl storage) {
        this.factory = factory;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> factory.getOperationHandlerFromOperation(transaction.getOperation())
                .perform(transaction, storage));
    }
}
