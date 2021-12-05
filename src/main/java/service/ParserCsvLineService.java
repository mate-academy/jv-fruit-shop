package service;

import model.Fruit;
import model.Operation;
import model.Transaction;

public class ParserCsvLineService implements Parser {
    private static final String SEPARATOR = ",";
    private static final int INDEX_TYPE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private static final int TOTAL_ELEMENTS = 3;

    @Override
    public Transaction parseLine(String line) {
        String[] partOfLine = line.split(SEPARATOR);
        if (partOfLine.length != TOTAL_ELEMENTS) {
            throw new RuntimeException("Wrong input line " + line);
        }
        Operation operation = Operation.get(partOfLine[INDEX_TYPE]);
        Fruit fruit = new Fruit(partOfLine[INDEX_FRUIT]);
        int amount;
        try {
            amount = Integer.parseInt(partOfLine[INDEX_AMOUNT]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong fruit amount " + line);
        }
        if (amount <= 0) {
            throw new RuntimeException("Wrong fruit amount");
        }
        return new Transaction(operation, fruit, amount);
    }
}
