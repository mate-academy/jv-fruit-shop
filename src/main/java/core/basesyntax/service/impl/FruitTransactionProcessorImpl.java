package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategyImpl operationStrategyImpl;

    public FruitTransactionProcessorImpl(OperationStrategyImpl operationStrategyImpl) {
        this.operationStrategyImpl = operationStrategyImpl;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        transactionList.forEach(fruitTransaction -> operationStrategyImpl
                .get(fruitTransaction.operation())
                .performOperation(fruitTransaction.name(), fruitTransaction.quantity()));
    }
}
