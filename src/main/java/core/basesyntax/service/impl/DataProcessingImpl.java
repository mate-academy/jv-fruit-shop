package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessingImpl implements DataProcessing {
    private FruitsDao fruitsDao;
    private OperationStrategy operationStrategy;

    public DataProcessingImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void run(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .runOperation(fruitsDao,
                            fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity());
        }
    }
}
