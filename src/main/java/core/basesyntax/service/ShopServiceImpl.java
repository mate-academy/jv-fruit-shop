package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ShopService;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        Map<String, Integer> storage = Storage.getInventory();
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(storage, transaction);
        }
    }
}
