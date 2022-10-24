package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitShopStrategy;

import java.util.List;
import java.util.Map;

public class FruitService {
    private final Map<FruitTransaction.Operation, FruitShopStrategy> operationsMap;

    public FruitService(Map<FruitTransaction.Operation, FruitShopStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction
                -> operationsMap.get(transaction.getOperation()).apply(transaction));
    }
}
