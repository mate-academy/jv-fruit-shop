package core.service.handler;

import core.model.Transaction;

import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void applyOperation(Transaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getProduct(), transaction.getQuantity());
    }
}
