package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            transactions.add(parseLine(line));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(",");
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation.getOperationByCode(parts[0]));
        transaction.setFruit(parts[1]);
        transaction.setQuantity(Integer.parseInt(parts[2]));
        return transaction;
    }
}
