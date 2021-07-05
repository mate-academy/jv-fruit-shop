package service;

import dto.TransferObject;

public class FruitParser implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATOR_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public TransferObject parse(String line) {
        String[] lineParse = line.split(SEPARATOR);
        FruitValidator fruitValidator = new FruitValidator();
        if (!fruitValidator.validate(lineParse)) {
            throw new RuntimeException("Incorrect input");
        }
        return new TransferObject(lineParse[OPERATOR_INDEX],
                lineParse[NAME_INDEX],
                Integer.parseInt(lineParse[QUANTITY_INDEX]));
    }
}
