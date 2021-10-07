package service;

import static service.ParsingServiceImpl.ACTIVITY_INDEX;
import static service.ParsingServiceImpl.AMOUNT_INDEX;
import static service.ParsingServiceImpl.FRUIT_INDEX;

import java.util.Arrays;
import java.util.function.Predicate;

public class Validator implements Predicate<String[]> {
    @Override
    public boolean test(String[] splitArray) {
        if (splitArray.length != 3) {
            throw new RuntimeException("Incorrect format of the line: "
                    + Arrays.toString(splitArray));
        }
        if (splitArray[ACTIVITY_INDEX].isEmpty()) {
            throw new RuntimeException("Activity is empty");
        }
        if (splitArray[FRUIT_INDEX].isEmpty()) {
            throw new RuntimeException("Fruit name is empty");
        }
        if (splitArray[AMOUNT_INDEX].isEmpty()) {
            throw new RuntimeException("Amount is empty");
        }
        int amount;
        try {
            amount = Integer.parseInt(splitArray[AMOUNT_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect number: " + splitArray[AMOUNT_INDEX]);
        }
        if (amount < 0) {
            throw new RuntimeException("Incorrect amount: " + amount);
        }
        return true;
    }
}
