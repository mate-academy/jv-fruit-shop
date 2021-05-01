package service.validator;

import exception.InvalidInputException;
import java.util.function.Predicate;

public class DataValidator implements Predicate<String> {
    public static final int DATA_ELEMENTS = 3;
    public static final String COMMA = ",";
    public static final String NEGATIVE_INPUT_MESSAGE = "quantity can't be negative";
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";

    @Override
    public boolean test(String data) {
        String[] dataArr = data.split(COMMA);
        if (dataArr.length != DATA_ELEMENTS) {
            return false;
        }
        try {
            if (Integer.parseInt(dataArr[2]) < 0) {
                throw new InvalidInputException(NEGATIVE_INPUT_MESSAGE);
            }
        } catch (NumberFormatException e) {
            return false;
        }
        String activity = dataArr[0];
        return BALANCE.equals(activity)
                || PURCHASE.equals(activity)
                || SUPPLY.equals(activity)
                || RETURN.equals(activity);
    }
}
