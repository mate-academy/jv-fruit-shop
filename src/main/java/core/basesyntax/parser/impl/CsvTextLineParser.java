package core.basesyntax.parser.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.TextLineParser;

public class CsvTextLineParser implements TextLineParser {
    @Override
    public FruitTransaction extractOperationType(String line) {
        String[] lineArray = line.split(",");

        FruitTransaction.Operation operation;
        String fruit = lineArray[1];
        int quantity = Integer.parseInt(lineArray[2]);

        switch (lineArray[0].trim()) {
            case "b":
                operation = FruitTransaction.Operation.BALANCE;
                break;
            case "s":
                operation = FruitTransaction.Operation.SUPPLY;
                break;
            case "p":
                operation = FruitTransaction.Operation.PURCHASE;
                break;
            case "r":
                operation = FruitTransaction.Operation.RETURN;
                break;
            default: operation = null;
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
