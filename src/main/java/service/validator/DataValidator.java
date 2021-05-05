package service.validator;

import exception.InvalidInputException;
import java.util.function.Predicate;

public class DataValidator implements Predicate<String> {
    public static final int DATA_ELEMENTS = 3;
    public static final String CSV_SEPARATOR = ",";
    public static final String NEGATIVE_INPUT_MESSAGE = "quantity can't be negative";
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String SUPPLY = "s";
    public static final String RETURN = "r";
    public static final int QUANTITY_INDEX = 2;
    public static final int OPERATION_INDEX = 0;

    @Override
    public boolean test(String data) {
        String[] dataArr = data.split(CSV_SEPARATOR);
        if (dataArr.length != DATA_ELEMENTS) {
            return false;
        }
        try {
            if (Integer.parseInt(dataArr[QUANTITY_INDEX]) < 0) {
                throw new InvalidInputException(NEGATIVE_INPUT_MESSAGE);
            }
        } catch (NumberFormatException e) {
            return false;
        }
        String activity = dataArr[OPERATION_INDEX];
        return BALANCE.equals(activity)
                || PURCHASE.equals(activity)
                || SUPPLY.equals(activity)
                || RETURN.equals(activity);
    }
}
