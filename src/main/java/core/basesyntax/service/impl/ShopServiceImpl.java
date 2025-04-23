package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;

import java.util.List;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategyService operationStrategyService;
    private final Storage storage = new Storage();

    public ShopServiceImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategyService.getOperationHandler(transaction.getOperation());
            operationHandler.handle(storage, transaction);
        }
    }

    @Override
    public Storage getStorage() {
        return storage;
    }
}
