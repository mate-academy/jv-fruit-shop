package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceStorageServiceImpl;
import core.basesyntax.strategy.impl.PurchaseStorageServiceImpl;
import core.basesyntax.strategy.impl.ReturnStorageServiceImpl;
import core.basesyntax.strategy.impl.SupplyStorageServiceImpl;

public class StorageStrategy {
    public StorageService getStorageService(FruitTransaction transaction) {
        switch (transaction.getOperation().toString()) {
            case "BALANCE":
                return new BalanceStorageServiceImpl();
            case "SUPPLY":
                return new SupplyStorageServiceImpl();
            case "PURCHASE":
                return new PurchaseStorageServiceImpl();
            case "RETURN":
                return new ReturnStorageServiceImpl();
            default:
                throw new UnsupportedOperationException(
                        "Operation " + transaction.getOperation() + " is not supported");
        }
    }
}
