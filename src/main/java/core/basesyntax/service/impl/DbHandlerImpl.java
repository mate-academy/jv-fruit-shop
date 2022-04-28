package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DbHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DbHandlerImpl implements DbHandler {
    private OperationStrategy operationStrategy = new OperationStrategy();

    @Override
    public void proceed(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getOperation(transaction).proceed(transaction);
        }
    }
}
