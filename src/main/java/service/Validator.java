package service;

import java.util.function.Function;
import model.FruitRecord;

public class Validator implements Function<String, FruitRecord> {
    private static final int ACTIVITY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    public FruitRecord apply(String rawRecord) {
        String[] splitArray = rawRecord.split(",");
        if (splitArray.length != 3) {
            throw new RuntimeException("Incorrect format of the line: " + rawRecord);
        }
        String activity = splitArray[ACTIVITY_INDEX].trim();
        if (activity.isEmpty()) {
            throw new RuntimeException("Activity is empty");
        }
        String fruit = splitArray[FRUIT_INDEX].trim();
        if (fruit.isEmpty()) {
            throw new RuntimeException("Fruit name is empty");
        }
        if (splitArray[AMOUNT_INDEX].trim().isEmpty()) {
            throw new RuntimeException("Amount is empty");
        }
        int amount;
        try {
            amount = Integer.parseInt(splitArray[AMOUNT_INDEX].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect number: " + splitArray[AMOUNT_INDEX]);
        }
        if (amount < 0) {
            throw new RuntimeException("Incorrect amount: " + amount);
        }
        return new FruitRecord(activity, fruit, amount);
    }
}
