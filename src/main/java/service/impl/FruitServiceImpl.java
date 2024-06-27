package service.impl;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;
import service.FruitService;
import strategy.OperationHandler;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public FruitServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void applyTransaction(FruitTransaction transaction) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler != null) {
            handler.apply(transaction);
        } else {
            throw new RuntimeException("No handler found for operation: "
                    + transaction.getOperation());
        }
    }

    @Override
    public Map<String, Integer> getReportData() {
        return Storage.getFruitStorage();
    }
}
