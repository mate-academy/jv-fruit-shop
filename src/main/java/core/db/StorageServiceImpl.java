package core.db;

import core.service.OperationHandler;
import core.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class StorageServiceImpl implements StorageService<FruitTransaction> {
    @Override
    public Map<String, Integer> addFruit(FruitTransaction transaction) {
        OperationHandler handler = new OperationStrategy()
                .getOperationHandler(transaction.getOperation());
        handler.addTransaction(transaction);
        return new HashMap<>(Storage.fruitsMap);
    }

    @Override
    public Map<String, Integer> getLeftovers() {
        return Storage.fruitsMap;
    }

    public Integer getFruitQuantity(String fruit) {
        Integer fruitQuantity = Storage.fruitsMap.get(fruit);
        return fruitQuantity == null ? 0 : fruitQuantity;
    }

    public void setFruitQuantity(String fruit, Integer quantity) {
        Storage.fruitsMap.put(fruit, quantity);
    }
}
