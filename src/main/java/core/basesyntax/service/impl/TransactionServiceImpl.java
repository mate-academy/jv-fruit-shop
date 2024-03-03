package core.basesyntax.service.impl;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {

    private static final String TRANSACTION_IS_NULL_ERROR_MESSAGE =
            "The fruit transaction that you try to write into the file is null";
    private static final String ARGUMENT_IS_NULL_ERROR_MESSAGE = "Argument must not be null";
    private StoreCsvDao storeCsvDao;

    TransactionServiceImpl(StoreCsvDao storeCsvDao) {
        Optional.ofNullable(storeCsvDao)
                .orElseThrow(() -> new IllegalArgumentException(ARGUMENT_IS_NULL_ERROR_MESSAGE
                        + storeCsvDao));
        this.storeCsvDao = storeCsvDao;
    }

    @Override
    public void writeTransactionToFile(FruitTransaction fruitTransaction) {
        Optional.ofNullable(fruitTransaction)
                .orElseThrow(() -> new RuntimeException(TRANSACTION_IS_NULL_ERROR_MESSAGE));
        storeCsvDao.addLine(fruitTransaction);
    }
}
