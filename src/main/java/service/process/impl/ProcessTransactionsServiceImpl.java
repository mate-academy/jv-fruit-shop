package service.process.impl;

import java.util.List;
import model.FruitTransaction;
import service.operations.OperationsHandler;
import service.process.ProcessTransactionsService;
import service.strategy.OperationsStrategy;

public class ProcessTransactionsServiceImpl implements ProcessTransactionsService {
    private OperationsStrategy operationsStrategy;

    public ProcessTransactionsServiceImpl(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationsHandler operationsHandler = operationsStrategy
                    .get(fruitTransaction.getOperation());
            operationsHandler.doOperation(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
