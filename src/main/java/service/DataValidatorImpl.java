package service;

import exceptions.InvalidInputException;

public class DataValidatorImpl implements DataValidator {

    public static final String COMMA = ",";
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    public static final String SUPPLY = "s";
    public static final int ACTIVITY_INDEX = 0;
    public static final int QUANTITY_INDEX = 2;

    public void validateRecord(String record) {
        String[] data = record.split(COMMA);
        String activity = data[ACTIVITY_INDEX];
        try {
            int amount = Integer.parseInt(data[QUANTITY_INDEX]);
            if (amount < 0) {
                throw new InvalidInputException("Quantity can not be negative");
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Wrong input, unparsable value of fruits");
        }
        if (!(activity.equals(BALANCE)
                    || activity.equals(PURCHASE)
                    || activity.equals(RETURN)
                    || activity.equals(SUPPLY))) {
            throw new InvalidInputException("Activity is not supported");
        }
    }

    @Override
    public void validateFirstLine(String firstLine) {
        if (!firstLine.equals("activity,fruit,quantity")) {
            throw new InvalidInputException("Unknown file format");
        }
    }

    public void validateAmount(int newAmount) {
        if (newAmount < 0) {
            throw new InvalidInputException("Wrong quantity");
        }
    }
}
