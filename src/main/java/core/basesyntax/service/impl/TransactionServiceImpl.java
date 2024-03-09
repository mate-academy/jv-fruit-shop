package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.CodeService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            CodeService codeService =
                    operationStrategy.getCodeService(fruitTransaction.getOperation());
            codeService.doOperation(fruitTransaction);
        }
    }
}
