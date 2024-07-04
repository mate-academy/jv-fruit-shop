package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            OperationHandler operationHandler =
                    operationStrategy.get(transaction.getOperation());
            operationHandler.operationType(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}
