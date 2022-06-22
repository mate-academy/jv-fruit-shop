package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataOperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataOperationServiceImpl implements DataOperationService {
    private final OperationStrategy operationStrategy;

    public DataOperationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processOperation(List<FruitTransaction> fruitTransactionsList) {
        fruitTransactionsList.forEach(fruitTransaction ->
                operationStrategy.getOperationType(fruitTransaction.getOperation())
                .changeQuantity(fruitTransaction));
    }
}
