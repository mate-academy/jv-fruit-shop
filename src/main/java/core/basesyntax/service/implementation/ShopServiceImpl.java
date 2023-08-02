package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.StoreOperationsHandler;

public class ShopServiceImpl implements ShopService {
    @Override
    public void process(FruitTransaction transaction) {
        StoreOperationsHandler handler
                = FruitTransaction.PROCESS_SELECTOR.get(transaction.getOperation());
        handler.applyOperation(transaction.getFruit(), transaction.getQuantity());
    }
}
