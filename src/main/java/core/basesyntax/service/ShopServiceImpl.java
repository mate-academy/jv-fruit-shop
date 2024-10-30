package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servicehandler.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<FruitTransaction.Operation, FruitOperationHandler> operationHandlers;

    public ShopServiceImpl(Map<FruitTransaction.Operation,
            FruitOperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitOperationHandler handler = operationHandlers.get(transaction.getOperation());
            if (handler != null) {
                handler.handle(transaction);
            }
        }
    }
}
