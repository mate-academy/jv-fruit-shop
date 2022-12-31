package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceStorageService;
import core.basesyntax.strategy.impl.PurchaseStorageService;
import core.basesyntax.strategy.impl.ReturnStorageService;
import core.basesyntax.strategy.impl.SupplyStorageService;

import javax.swing.*;

public class StorageStrategy {
    public StorageService getStorageService(FruitTransaction transaction) {
        switch (transaction.getOperation().toString()) {
            case "SUPPLY":
                return new SupplyStorageService();
            case "PURCHASE":
                return new PurchaseStorageService();
            case "RETURN":
                return new ReturnStorageService();
            case "BALANCE":
            default:
                return new BalanceStorageService();
        }
    }
}
