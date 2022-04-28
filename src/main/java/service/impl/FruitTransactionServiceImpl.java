package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionService;
import strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String COMA = ",";
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<FruitTransaction> values) {
        values.forEach(e -> {
            operationStrategy.get(e.getOperation())
                    .apply(e.getFruit(), e.getQuantity());
        });
    }
}
