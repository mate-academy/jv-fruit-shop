package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new RuntimeException("operationStrategy can't be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            throw new RuntimeException("Transactions list can't be null or empty");
        }
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation currentOperation = transaction.getOperation();
            OperationHandler handler = operationStrategy.getHandler(currentOperation);
            handler.handle(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
