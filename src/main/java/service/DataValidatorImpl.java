package service;

import exceptions.InvalidInputException;

public class DataValidatorImpl implements DataValidator {

    public static final String COMMA = ",";
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    public static final String SUPPLY = "s";

    public void validateRecord(String record) {
        String[] data = record.split(COMMA);
        String action = data[0];
        try {
            Integer.parseInt(data[2]);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Wrong input, unparsable value of fruits");
        }
        int amount = Integer.parseInt(data[2]);
        if (!(action.equals(BALANCE)
                    || action.equals(PURCHASE)
                    || action.equals(RETURN)
                    || action.equals(SUPPLY))) {
            throw new InvalidInputException("Activity is not supported");
        }
        if (amount < 0) {
            throw new InvalidInputException("Quantity can not be negative");
        }
    }

    public void validateAmount(int newAmount) {
        if (newAmount < 0) {
            throw new InvalidInputException("Wrong quantity");
        }
    }
}
