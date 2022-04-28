package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionService;
import strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
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
