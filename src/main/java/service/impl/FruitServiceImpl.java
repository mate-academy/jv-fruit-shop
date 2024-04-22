package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitService;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(line -> {
            operationStrategy.get(line.getOperation()).executeTransaction(line);
        });
    }
}
