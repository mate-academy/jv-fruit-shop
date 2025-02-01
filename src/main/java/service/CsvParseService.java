package service;

import model.FruitTransaction;

public class CsvParseService implements Parser {
    @Override
    public FruitTransaction parseTransaction(String line) {
        int fruitNameIndex = 1;
        int quantityIndex = 2;
        int operationTypeIndex = 0;
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV format: " + line);
        }
        return new FruitTransaction(
                parts[fruitNameIndex],
                Integer.parseInt(parts[quantityIndex]),
                FruitTransaction.Operation.fromCode(parts[operationTypeIndex]));
    }
}
