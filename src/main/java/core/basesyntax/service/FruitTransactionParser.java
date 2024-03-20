package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

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
        transaction.setOperation(FruitTransaction.Operation
                .getOperationByCode(parts[OPERATION_INDEX]));
        transaction.setFruit(parts[FRUIT_INDEX]);
        transaction.setQuantity(Integer.parseInt(parts[QUANTITY_INDEX]));
        return transaction;
    }
}
