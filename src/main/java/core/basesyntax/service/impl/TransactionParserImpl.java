package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATE = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<Transaction> parseTransactionList(List<String> transactions) {
        List<Transaction> transactionList = new ArrayList<>();
        for (String line : transactions) {
            String[] fields = line.split(SEPARATE);
            Transaction transaction = new
                    Transaction(fields[INDEX_FRUIT], Integer.parseInt(fields[INDEX_QUANTITY]));
            transaction.setOperation(Transaction.Operation
                      .forValue(fields[INDEX_OPERATION].trim()));
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
