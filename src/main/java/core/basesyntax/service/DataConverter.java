package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {

    public List<FruitTransaction> convertDataToTransactions(List<String[]> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String[] row : data) {
            String operation = row[0];
            String fruit = row[1];
            int quantity = Integer.parseInt(row[2]);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }

        return transactions;
    }
}
