package core.basesyntax.service.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;

public class CsvParser implements TransactionParser {
    private static final String COMMA = ",";
    private static final int OPERATION_CODE = 0;
    private static final int PRODUCT_NAME = 1;
    private static final int PRODUCT_AMOUNT = 2;

    @Override
    public List<Transaction> parseTransactions(List<String> data) {
        return data.stream().map(this::lineToProductTransaction).toList();
    }

    private Transaction lineToProductTransaction(String line) {
        String[] transactionData = line.split(COMMA);
        Transaction.Operation operation =
                Transaction.Operation.fromCode(transactionData[OPERATION_CODE]);
        String product = transactionData[PRODUCT_NAME];
        int productAmount = Integer.parseInt(transactionData[PRODUCT_AMOUNT]);
        return new Transaction(operation, product, productAmount);
    }
}
