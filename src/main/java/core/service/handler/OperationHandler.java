package core.service.handler;

import core.model.Transaction;

import java.util.Map;

public interface OperationHandler {
    void applyOperation(Transaction transaction, Map<String, Integer> storage);
    
}
