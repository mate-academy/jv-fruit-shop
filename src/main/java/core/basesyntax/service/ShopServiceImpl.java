package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for(FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getOperationHandler(transaction.getOperation());
            operationHandler.recount(transaction);
        }
    }
}
