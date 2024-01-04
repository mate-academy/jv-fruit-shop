package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopService {

    private Storage storage;
    private OperationStrategy operationStrategy;

    public FruitShopService(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storage = new Storage();
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            operationHandler.handleOperation(transaction, storage);
        }
    }
}
