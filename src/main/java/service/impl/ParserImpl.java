package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.Parser;

public class ParserImpl implements Parser {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : lines) {
            FruitTransaction fruitTransaction = parseLine(line);
            if (fruitTransaction != null) {
                fruitTransactionList.add(fruitTransaction);
            }
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseLine(String line) {
        final int operationIndex = 0;
        final int fruitIndex = 1;
        final int quantityIndex = 2;
        String[] fields = line.split(",");
        Operation operation;
        try {
            operation = Operation.getOperation(fields[operationIndex].trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
        String fruit = fields[fruitIndex].trim();
        int quantity = Integer.parseInt(fields[quantityIndex].trim());
        return new FruitTransaction(operation, fruit, quantity);
    }
}
