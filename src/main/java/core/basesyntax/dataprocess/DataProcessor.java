package core.basesyntax.dataprocess;

import static core.basesyntax.db.Storage.fruitData;
import static core.basesyntax.model.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.model.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.model.FruitTransaction.Operation.RETURN;
import static core.basesyntax.model.FruitTransaction.Operation.SUPPLY;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceService;
import core.basesyntax.strategy.impl.PurchaseService;
import core.basesyntax.strategy.impl.ReturnService;
import core.basesyntax.strategy.impl.SupplyService;
import java.util.List;
import java.util.Map;

public class DataProcessor {
    private final Map<FruitTransaction.Operation, Strategy> strategyMap;

    public DataProcessor() {
        this.strategyMap = initializeStrategyMap();
    }

    private Map<FruitTransaction.Operation, Strategy> initializeStrategyMap() {
        return Map.of(
                BALANCE, new BalanceService(),
                SUPPLY, new SupplyService(),
                PURCHASE, new PurchaseService(),
                RETURN, new ReturnService()
        );
    }

    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            strategyMap.get(operation).processData(fruitData,
                    transaction.getFruit(), transaction.getQuantity());
        }
    }

    public Map<String, Integer> getFruitData() {
        return fruitData;
    }
}
