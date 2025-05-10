package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;

public class ShopServiceImpl implements ShopService {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Empty list of transactions!");
        }
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation currentOperation = transaction.getOperation();
            if (currentOperation == null) {
                continue;
            }
            OperationHandler handler = operationHandlers.get(currentOperation);
            if (handler == null) {
                throw new IllegalArgumentException("Unsupported operation: " + currentOperation);
            }
            handler.doOperation(transaction);
        }
    }
}
