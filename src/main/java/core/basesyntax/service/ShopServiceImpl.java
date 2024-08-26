package core.basesyntax.service;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitStorage fruitStorage;

    public ShopServiceImpl(OperationStrategy operationStrategy, FruitStorage fruitStorage) {
        this.operationStrategy = operationStrategy;
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }
    }

    public Map<String, Integer> getFruitStorage() {
        return fruitStorage.getAllFruits();
    }

}
