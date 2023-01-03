package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceStorageService;
import core.basesyntax.strategy.impl.PurchaseStorageService;
import core.basesyntax.strategy.impl.ReturnStorageService;
import core.basesyntax.strategy.impl.SupplyStorageService;

public class StorageStrategy {
    public StorageService getStorageService(FruitTransaction transaction) {
        switch (transaction.getOperation().toString()) {
            case "BALANCE":
                return new BalanceStorageService();
            case "SUPPLY":
                return new SupplyStorageService();
            case "PURCHASE":
                return new PurchaseStorageService();
            case "RETURN":
                return new ReturnStorageService();
            default:
                throw new UnsupportedOperationException(
                        "Operation " + transaction.getOperation() + " is not supported");
        }
    }
}
