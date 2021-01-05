package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void createReport(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            operationStrategy.getOperationHandler(transaction.getOperation())
                    .changeReportInStorage(transaction);
        }
    }
}
