package service;

import dto.Transaction;

public class FruitParser implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATOR_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private Validator fruitValidator;

    public FruitParser(Validator fruitValidator) {
        this.fruitValidator = fruitValidator;
    }

    @Override
    public Transaction parse(String line) {
        String[] parsedLine = line.split(SEPARATOR);
        if (!fruitValidator.validate(parsedLine)) {
            throw new RuntimeException("Incorrect input");
        }
        return new Transaction(parsedLine[OPERATOR_INDEX],
                parsedLine[NAME_INDEX],
                Integer.parseInt(parsedLine[QUANTITY_INDEX]));
    }
}
