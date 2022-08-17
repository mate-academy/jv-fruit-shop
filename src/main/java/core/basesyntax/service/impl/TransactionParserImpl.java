package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int LINES_TO_SKIP = 1;

    @Override
    public List<FruitTransaction> getTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(LINES_TO_SKIP)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsvRow(String transaction) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] strings = transaction.split(",");
        fruitTransaction.setOperation(operationRecognaizer(strings[0]));
        fruitTransaction.setFruit(strings[1]);
        fruitTransaction.setQuantity(Integer.parseInt(strings[2]));
        return fruitTransaction;
    }

    private FruitTransaction.Operation operationRecognaizer(String string) {
        switch (string) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("Incorrect type of activity in the source file: " + string);
        }
    }
}
