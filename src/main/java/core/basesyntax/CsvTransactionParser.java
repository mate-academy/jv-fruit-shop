package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactionLines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String transactionLine : transactionLines) {
            String[] transactionData = transactionLine.split(",");
            String operation = transactionData[OPERATION_INDEX];
            String fruitName = transactionData[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(transactionData[QUANTITY_INDEX]);
            transactions.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
