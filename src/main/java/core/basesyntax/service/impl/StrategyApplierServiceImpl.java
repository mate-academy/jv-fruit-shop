package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyApplierService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StrategyApplierServiceImpl implements StrategyApplierService {
    @Override
    public void applyMethod(List<FruitTransaction> fruitTransactions, OperationStrategy strategy) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.applyOperation(fruitTransaction);
        }
    }
}
