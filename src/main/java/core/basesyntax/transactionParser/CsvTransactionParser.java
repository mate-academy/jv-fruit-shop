package core.basesyntax.transactionParser;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;


import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser{
    private Operation operation;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] transactionData = line.split(",");
            String fruitName = transactionData[0];
            int quantity = Integer.parseInt(transactionData[1]);
            transactions.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
