package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {

    private static final String TRANSACTION_IS_NULL_ERROR_MESSAGE =
            "The fruit transaction that you try to write into the file is null";
    private static final String ARGUMENT_IS_NULL_ERROR_MESSAGE = "Argument must not be null";
    private FruitTransactionDao fruitTransactionDao;

    TransactionServiceImpl(FruitTransactionDao fruitTransactionDao) {
        Optional.ofNullable(fruitTransactionDao)
                .orElseThrow(() -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + fruitTransactionDao));
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void writeTransactionToFile(FruitTransaction fruitTransaction) {
        Optional.ofNullable(fruitTransaction)
                .orElseThrow(() -> new IllegalArgumentException(TRANSACTION_IS_NULL_ERROR_MESSAGE));
        fruitTransactionDao.addTransaction(fruitTransaction);
    }
}
