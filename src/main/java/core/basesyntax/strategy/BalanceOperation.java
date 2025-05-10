package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.ShopOperation;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(ShopOperation shopOperation) {
        Storage.fruitsStorage.put(shopOperation.getFruit(), shopOperation.getQuantity());
    }
}
