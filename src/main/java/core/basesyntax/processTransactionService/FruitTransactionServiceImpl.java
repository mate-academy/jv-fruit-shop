package core.basesyntax.processTransactionService;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.serviceOperate.OperationStrategy;

import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> transactionList) {
        transactionList.forEach(transaction ->
                operationStrategy.getOperationHandler(transaction.getOperation())
                .operation(transaction));
    }
}
