package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(SEPARATOR);
            if (parts.length == 3) {
                String operationCode = parts[OPERATION_CODE_INDEX];
                String fruit = parts[FRUIT_INDEX];
                int quantity = Integer.parseInt(parts[2]);
                transactions.add(new FruitTransaction(
                        FruitTransaction.Operation.valueOf(operationCode),
                        fruit,
                        quantity
                ));
            }
        }
        return transactions;
    }
}
