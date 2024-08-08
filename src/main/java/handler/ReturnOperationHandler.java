package handler;

import java.util.Map;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage;

    public ReturnOperationHandler(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
