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
        for (FruitTransaction transaction : transactions) {
            operationHandlers.get(transaction.getOperation()).doOperation(transaction);
        }
    }
}
