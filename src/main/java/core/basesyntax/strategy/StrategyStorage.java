package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import java.util.HashMap;

public class StrategyStorage {
    private HashMap<String, OperationStrategy> strategyStorage = new HashMap<>();

    public StrategyStorage() {
        strategyStorage.put(FruitTransaction.Operation.BALANCE.getCode(), new BalanceOperation());
        strategyStorage.put(FruitTransaction.Operation.SUPPLY.getCode(), new SupplyOperation());
        strategyStorage.put(FruitTransaction.Operation.PURCHASE.getCode(), new PurchaseOperation());
        strategyStorage.put(FruitTransaction.Operation.RETURN.getCode(), new ReturnOperation());
    }

    public HashMap<String, OperationStrategy> getStrategyStorage() {
        return strategyStorage;
    }

    public void setStrategyStorage(HashMap<String, OperationStrategy> strategyStorage) {
        this.strategyStorage = strategyStorage;
    }

    public OperationStrategy getStrategy(String data) {
        return strategyStorage.get(data);
    }
}
