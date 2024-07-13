package service;

import java.util.Map;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
