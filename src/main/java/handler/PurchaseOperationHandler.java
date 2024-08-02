package handler;

import java.util.Map;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage;

    public PurchaseOperationHandler(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0) - transaction.getQuantity());
    }
}
