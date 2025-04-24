package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategyService;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategyService operationStrategyService;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
        this.storage = new Storage();
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler operationHandler =
                    operationStrategyService.getOperationHandler(transaction.getOperation());
            operationHandler.handle(this, transaction);
        }
    }

    @Override
    public Map<String, Integer> getReportData() {
        return storage.getFruitQuantities();
    }

    public void updateStorage(String fruit, int quantity) {
        storage.addQuantity(fruit, quantity);
    }

    public void reduceStorage(String fruit, int quantity) {
        try {
            storage.removeQuantity(fruit, quantity);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
