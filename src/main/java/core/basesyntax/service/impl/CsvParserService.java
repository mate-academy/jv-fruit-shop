package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class CsvParserService implements ParserService {
    @Override
    public List<FruitTransaction> parseCsv(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (String line : lines) {
            FruitTransaction transaction = parseCsvLine(line);
            fruitTransactions.add(transaction);
        }

        return fruitTransactions;
    }

    private FruitTransaction parseCsvLine(String line) {
        String[] parsedArray = line.split(",");

        if (parsedArray.length == 3 && !parsedArray[0].equalsIgnoreCase("type")) {
            String operationCode = parsedArray[0].trim();
            String fruit = parsedArray[1].trim();

            try {
                int quantity = Integer.parseInt(parsedArray[2].trim());

                FruitTransaction.Operation operation = mapOperation(operationCode);

                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(operation);
                transaction.setFruit(fruit);
                transaction.setQuantity(quantity);

                return transaction;
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity format in line: " + line);
                return null;
            }
        } else {
            return null;
        }
    }

    private FruitTransaction.Operation mapOperation(String code) {
        switch (code) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("Unknown operation code: " + code);
        }
    }
}
