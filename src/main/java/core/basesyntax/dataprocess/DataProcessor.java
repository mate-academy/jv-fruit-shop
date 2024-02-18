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
import java.util.Optional;

public class DataProcessor {
    private final Map<String, Strategy> strategyMap;

    public DataProcessor() {
        this.strategyMap = initializeStrategyMap();
    }

    private Map<String, Strategy> initializeStrategyMap() {
        return Map.of(
                BALANCE.getCode(), new BalanceService(),
                SUPPLY.getCode(), new SupplyService(),
                PURCHASE.getCode(), new PurchaseService(),
                RETURN.getCode(), new ReturnService()
        );
    }

    public void processTransactions(List<FruitTransaction> fruitTransactions,
                                    Map<String, Integer> fruitData) {
        for (FruitTransaction transaction : fruitTransactions) {
            String operation = transaction.getOperation().getCode();
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            Optional.ofNullable(strategyMap.get(operation))
                    .ifPresentOrElse(strategy -> strategy
                                    .processData(fruitData, fruit, quantity),
                            () -> {
                                throw new IllegalArgumentException("Unknown operation: "
                                        + operation);
                            });
        }
    }

    public Map<String, Integer> getFruitData() {
        return fruitData;
    }
}
