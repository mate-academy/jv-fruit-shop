package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {

    public FruitServiceImpl(FruitStorage fruitStorage) {
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (OperationStrategy.valueOf(transaction.parseOperation().toString()) == null) {
                throw new NullPointerException("operation not exist");
            }
            OperationStrategy operation = OperationStrategy.valueOf(transaction.parseOperation()
                        .toString().toUpperCase());
            OperationHandler handler = operation.getHandler();
            handler.handleOperation(transaction);
        }
    }
}
