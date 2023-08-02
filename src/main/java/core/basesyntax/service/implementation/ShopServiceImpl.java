package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.FruitShopOperationsHandler;

public class ShopServiceImpl implements ShopService {
    @Override
    public void process(FruitTransaction transaction) {
        FruitShopOperationsHandler handler
                = FruitTransaction.PROCESS_SELECTOR.get(transaction.getOperation());
        handler.applyOperation(transaction.getFruit(), transaction.getQuantity());
    }
}
