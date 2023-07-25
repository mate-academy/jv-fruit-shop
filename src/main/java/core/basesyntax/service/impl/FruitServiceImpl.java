package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Operations;
import java.util.ArrayList;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    FruitStorage fruitStorage = new FruitStorage();

    public FruitServiceImpl(FruitStorage fruitStorage) {
    }

    public FruitStorage getFruitStorage() {
        return fruitStorage;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (Operations.valueOf(transaction.getOperation().toString()) == null)
                throw new NullPointerException("operation not exist");
                Operations operation = Operations.valueOf(transaction.getOperation()
                        .toString().toUpperCase());
                OperationHandler handler = operation.getHandler();
                handler.handleOperation(transaction);
        }
    }
}
