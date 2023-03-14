package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.HashMap;

public class StrategyStorage {
    private HashMap<String, OperationHandler> strategyStorage = new HashMap<>();

    public StrategyStorage() {
        strategyStorage.put(FruitTransaction.Operation.BALANCE.getCode(),
                new BalanceOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.SUPPLY.getCode(),
                new SupplyOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.PURCHASE.getCode(),
                new PurchaseOperationStrategy());
        strategyStorage.put(FruitTransaction.Operation.RETURN.getCode(),
                new ReturnOperationStrategy());
    }

    public HashMap<String, OperationHandler> getStrategyStorage() {
        return strategyStorage;
    }

    public void setStrategyStorage(HashMap<String, OperationHandler> strategyStorage) {
        this.strategyStorage = strategyStorage;
    }

    public OperationHandler getStrategy(String data) {
        return strategyStorage.get(data);
    }
}
