package core.basesyntax.service.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    private static final String CHAR_FOR_SPLIT = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final TransactionDao transactionDao = new TransactionDaoImpl();

    @Override
    public void registerNewTransaction(String transactionInfo) {
        FruitTransaction transaction = new FruitTransaction();
        String[] splitTransactionInfo = transactionInfo.split(CHAR_FOR_SPLIT);
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .get(splitTransactionInfo[INDEX_OPERATION]);
        transaction.setOperation(operation);
        transaction.setFruit(splitTransactionInfo[INDEX_FRUIT]);
        transaction.setQuantity(Integer.parseInt(splitTransactionInfo[INDEX_QUANTITY]));
        transactionDao.addTransaction(transaction);
    }
}
