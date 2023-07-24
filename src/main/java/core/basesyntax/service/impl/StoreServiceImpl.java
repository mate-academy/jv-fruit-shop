package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.service.StoreService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private static final String INVALID_INPUT_PARAMETER
            = "Invalid input parameter in putToMap()";
    private OperationStrategy operationStrategy;

    public StoreServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void putToMap(List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        fruitTransactionList.stream()
                .forEach(fruitTransaction -> operationStrategy
                        .get(fruitTransaction.getOperation())
                        .handle(fruitTransaction));
    }
}
