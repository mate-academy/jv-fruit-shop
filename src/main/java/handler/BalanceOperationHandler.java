package handler;

import java.util.Map;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final Map<String, Integer> storage;

    public BalanceOperationHandler(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}

