package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionOperationsCalculator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionOperationsCalculatorImpl implements FruitTransactionOperationsCalculator {
    private OperationStrategy operationStrategy;

    public FruitTransactionOperationsCalculatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<FruitTransaction> process(FruitDao dao) {
        List<FruitTransaction> transactions = dao.get();
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation().toString().equalsIgnoreCase("b")) {
                operationStrategy.get(FruitTransaction.Operation.BALANCE).handle(transaction);
            }
            if (transaction.getOperation().toString().equalsIgnoreCase("s")) {
                operationStrategy.get(FruitTransaction.Operation.SUPPLY).handle(transaction);
            }
            if (transaction.getOperation().toString().equalsIgnoreCase("p")) {
                operationStrategy.get(FruitTransaction.Operation.PURCHASE).handle(transaction);
            }
            if (transaction.getOperation().toString().equalsIgnoreCase("r")) {
                operationStrategy.get(FruitTransaction.Operation.RETURN).handle(transaction);
            }
        }
        return dao.getByOperation("b");
    }
}
