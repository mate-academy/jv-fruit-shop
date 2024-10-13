package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private Map<String, Integer> storage = new HashMap<>();
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {

    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction, storage);
        }
    }
}
