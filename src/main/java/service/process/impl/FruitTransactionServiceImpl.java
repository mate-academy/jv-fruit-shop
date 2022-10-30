package service.process.impl;

import java.util.List;
import model.FruitTransaction;
import service.operations.OperationHandler;
import service.process.FruitTransactionService;
import service.strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.doOperation(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
