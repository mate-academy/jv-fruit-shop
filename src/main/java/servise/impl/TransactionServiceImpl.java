package servise.impl;

import model.Transaction;
import servise.TransactionService;
import strategy.TransactionStrategy;

public class TransactionServiceImpl implements TransactionService {
    private static final String COMMA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final TransactionStrategy transactionStrategy;

    public TransactionServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public Transaction createTransaction(String record) {
        String[] recordSplit = record.split(COMMA_DELIMITER);
        String operation = recordSplit[OPERATION_INDEX];
        String item = recordSplit[ITEM_INDEX];
        int quantity = Integer.parseInt(recordSplit[QUANTITY_INDEX]);
        return transactionStrategy.get(operation).getTransaction(item, quantity);
    }
}
