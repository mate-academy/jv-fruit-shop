package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage = new Storage();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(storage, transaction);
        }
    }

    public Map<String, Integer> getStorageReport() {
        return storage.getStorage();
    }
}


