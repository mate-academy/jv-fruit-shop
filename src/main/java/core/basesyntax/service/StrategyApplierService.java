package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface StrategyApplierService {
    void applyMethod(List<FruitTransaction> transactionList, OperationStrategy strategy);
}
