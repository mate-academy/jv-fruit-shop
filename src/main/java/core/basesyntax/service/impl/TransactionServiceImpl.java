package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.CodeService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            if (fruitTransaction.getFruit().isBlank()) {
                throw new RuntimeException("Fruit name is empty");
            }
            if (fruitTransaction.getQuantity() < 0) {
                throw new RuntimeException("Fruits "
                        + fruitTransaction.getFruit() + " less than 0");
            }
            if (!Arrays.stream(FruitTransaction.Operation.values()).toList()
                    .contains(fruitTransaction.getOperation())) {
                throw new RuntimeException("Operation isn`t correct: "
                        + fruitTransaction.getOperation());
            }

            CodeService codeService =
                    operationStrategy.getCodeService(fruitTransaction.getOperation());
            codeService.doOperation(fruitTransaction);
        }
        return true;
    }
}
