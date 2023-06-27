package core.basesyntax.service.transaction.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.InvalidFruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transaction.FruitTransactionService;
import core.basesyntax.service.transaction.FruitTransactionValidator;
import core.basesyntax.strategy.FruitTransactionOperationStrategy;
import java.util.List;

public class DefaultFruitTransactionService implements FruitTransactionService {
    private final FruitTransactionValidator fruitTransactionValidator;
    private final FruitTransactionOperationStrategy fruitTransactionOperationStrategy;
    private final FruitDao fruitDao;

    public DefaultFruitTransactionService(FruitTransactionValidator ftValidator,
                                          FruitTransactionOperationStrategy ftOperationStrategy,
                                          FruitDao ftDao) {
        this.fruitTransactionValidator = ftValidator;
        this.fruitTransactionOperationStrategy = ftOperationStrategy;
        this.fruitDao = ftDao;
    }

    @Override
    public void processSingleTransaction(FruitTransaction fruitTransaction) {
        if (!fruitTransactionValidator.isValid(fruitTransaction)) {
            throw new InvalidFruitTransactionException(
                    "Invalid FruitTransaction: " + fruitTransaction
            );
        }
        int amount = fruitTransactionOperationStrategy
                .getHandler(fruitTransaction.getOperation())
                .handle(fruitTransaction.getQuantity());
        fruitDao.updateQuantity(fruitTransaction.getFruit(), amount);
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(this::processSingleTransaction);
    }
}
