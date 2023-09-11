package core.basesyntax.parser;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser {
    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String operationCode = parts[0];
                String fruit = parts[1];
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
