package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessImpl implements DataProcess {
    @Override
    public void addDataToDB(List<FruitTransaction> fruitTransactions,
                            OperationStrategy operationStrategy) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationStrategy(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
