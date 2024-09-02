package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<String, Integer> storage = Storage.getStorage();
    private final OperationStrategy operationStrategy;

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

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
