package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionOperationsCalculator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionOperationsCalculatorImpl
        implements FruitTransactionOperationsCalculator {
    private OperationStrategy operationStrategy;

    public FruitTransactionOperationsCalculatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> process(FruitDao dao) {
        List<FruitTransaction> transactions = dao.get();
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
        return dao.getByOperation(FruitTransaction.Operation.BALANCE);
    }
}
