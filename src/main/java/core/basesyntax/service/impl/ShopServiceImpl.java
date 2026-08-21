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
        Map<String, Integer> fruits = Storage.getFruits();
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            int currentQuantity = fruits.getOrDefault(transaction.getFruit(), 0);
            int newQuantity = handler.apply(currentQuantity, transaction.getQuantity());
            if (newQuantity < 0) {
                throw new RuntimeException("Quantity can't be less than 0");
            }
            fruits.put(transaction.getFruit(), newQuantity);
        }
    }
}
