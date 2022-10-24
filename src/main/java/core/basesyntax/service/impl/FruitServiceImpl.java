package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitShopStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, FruitShopStrategy> operationsMap;

    public FruitServiceImpl(Map<FruitTransaction.Operation, FruitShopStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction
                -> operationsMap.get(transaction.getOperation()).apply(transaction));
    }
}
