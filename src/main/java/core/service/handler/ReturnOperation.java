package core.service.handler;

import core.model.Transaction;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void applyOperation(Transaction transaction, Map<String, Integer> storage) {
        Integer currentInStorage = storage.get(transaction.getProduct());
        int remainder = currentInStorage + transaction.getQuantity();
        storage.put(transaction.getProduct(), remainder);
    }
}
