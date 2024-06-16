package core.basesyntax.dataservices;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> transactions) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (String transaction : transactions) {
            String[] parts = transaction.split(",");
            FruitTransaction.Operation operation = operationFromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactionList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactionList;
    }

    private static FruitTransaction.Operation operationFromCode(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Invalid operation code: " + code);
        };
    }
}
