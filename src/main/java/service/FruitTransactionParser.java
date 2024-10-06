package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.OperationType;

public class FruitTransactionParser {
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(",");
            OperationType operation = OperationType.fromCode(data[0]);
            String fruit = data[1];
            int quantity = Integer.parseInt(data[2]);
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
