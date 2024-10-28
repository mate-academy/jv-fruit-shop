package core.basesyntax.shopserviceandreportgenerator;

import core.basesyntax.opationstrategy.OperationHandler;
import core.basesyntax.opationstrategy.OperationStrategy;
import core.basesyntax.operations.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction.getFruit(), transaction.getQuantity(), storage);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
