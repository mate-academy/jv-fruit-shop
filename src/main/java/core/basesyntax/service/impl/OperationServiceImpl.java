package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.OperationStrategy;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationStrategy operationStrategy;

    public OperationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitShopTransactions> fruitShopTransactions) {
        fruitShopTransactions.forEach(f -> operationStrategy
                        .getOperationHandler(f.getOperation())
                        .makeOperation(f));
    }
}
