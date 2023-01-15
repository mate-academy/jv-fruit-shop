package service;

import model.Fruit;

public class ValidatorImpl implements Validator {
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final int ELEMENTS_AMOUNT = 3;

    @Override
    public FruitTransaction parse(String line) {
        String[] splitLine = line.split(SEPARATOR);
        validator(splitLine);
        return new FruitTransaction(splitLine[TRANSACTION_INDEX],
                new Fruit(splitLine[FRUIT_INDEX]),
                        Integer.parseInt(splitLine[FRUIT_AMOUNT_INDEX]));
    }

    private void validator(String[] value) {
        if (value.length != ELEMENTS_AMOUNT || Integer.parseInt(value[FRUIT_AMOUNT_INDEX]) <= 0) {
            throw new RuntimeException("Data format is invalid");
        }
    }
}
