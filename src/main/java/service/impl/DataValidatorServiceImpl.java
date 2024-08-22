package service.impl;

import service.ValidatorService;

public class DataValidatorServiceImpl implements ValidatorService {
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DEFAULT_TRANSACTION_LENGTH = 3;

    @Override
    public void validate(String[] data) {
        if (data.length != DEFAULT_TRANSACTION_LENGTH) {
            throw new RuntimeException("This data has incorrect length: " + data.length);
        }
        if (data[FRUIT_INDEX].isBlank()) {
            throw new RuntimeException("The name of the fruit cannot be blank");
        }
        if (data[FRUIT_INDEX].equals("null")) {
            throw new RuntimeException("The name of the fruit cannot be null");
        }
        if (data[QUANTITY_INDEX].isBlank()) {
            throw new RuntimeException("The quantity can't be empty");
        }
        if (!data[QUANTITY_INDEX].matches("\\d+")) {
            throw new RuntimeException("The quantity must consist of numbers only: "
                    + data[QUANTITY_INDEX]);
        }
        if (Integer.parseInt(data[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("The quantity can't be less than zero: "
                    + data[QUANTITY_INDEX]);
        }
    }
}
