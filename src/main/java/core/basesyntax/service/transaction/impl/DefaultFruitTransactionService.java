package core.basesyntax.service.transaction.impl;

import core.basesyntax.exception.InvalidFruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.FruitTransactionService;
import core.basesyntax.service.transaction.FruitTransactionValidator;
import core.basesyntax.strategy.FruitTransactionOperationStrategy;
import java.util.List;

public class DefaultFruitTransactionService implements FruitTransactionService {
    private final FruitTransactionValidator fruitTransactionValidator;
    private final FruitTransactionOperationStrategy fruitTransactionOperationStrategy;

    public DefaultFruitTransactionService(FruitTransactionValidator ftValidator,
                                          FruitTransactionOperationStrategy ftOperationStrategy) {
        this.fruitTransactionValidator = ftValidator;
        this.fruitTransactionOperationStrategy = ftOperationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(this::processSingleTransaction);
    }

    private void processSingleTransaction(FruitTransaction fruitTransaction) {
        if (!fruitTransactionValidator.isValid(fruitTransaction)) {
            throw new InvalidFruitTransactionException(
                    "Invalid FruitTransaction: " + fruitTransaction
            );
        }
        fruitTransactionOperationStrategy
                .getHandler(fruitTransaction.getOperation())
                .handle(fruitTransaction);
    }
}
