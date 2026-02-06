package basesyntax.service.impl;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;
import basesyntax.service.ShopService;
import basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler =
                    operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }

        return Storage.getFruits();
    }
}
