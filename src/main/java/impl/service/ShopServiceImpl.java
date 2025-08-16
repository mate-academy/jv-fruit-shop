package impl.service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationHandler;

public class ShopServiceImpl implements ShopService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transactions list cannot be null");
        }
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }
            handler.apply(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
