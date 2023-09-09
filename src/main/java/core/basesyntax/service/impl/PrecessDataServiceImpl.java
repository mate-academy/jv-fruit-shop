package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.PrecessDataService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class PrecessDataServiceImpl implements PrecessDataService {
    private OperationStrategy operationStrategy;

    public PrecessDataServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void writeToStorage(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.forEach(f -> operationStrategy.get(f.getOperation()).process(f));
    }
}
