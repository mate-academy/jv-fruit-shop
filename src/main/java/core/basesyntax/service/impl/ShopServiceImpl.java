package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transactions list cannot be null.");
        }

        Map<String, Integer> fruitStorage = Storage.getFruitStorage();

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy
                    .getHandler(transaction.getOperation());
            int currentQuantity = fruitStorage
                    .getOrDefault(transaction.getFruit(), 0);

            int newQuantity = handler.apply(currentQuantity, transaction.getQuantity());
            fruitStorage.put(transaction.getFruit(), newQuantity);
        }
    }
}
