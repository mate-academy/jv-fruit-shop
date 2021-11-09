package core.basesyntax.service;

import java.util.Arrays;
import java.util.function.Predicate;

public class Validator implements Predicate<String[]> {

    @Override
    public boolean test(String[] dailyOperations) {
        if (dailyOperations.length != 3) {
            throw new RuntimeException("Incorrect format of daily operation: "
                    + Arrays.toString(dailyOperations));
        }
        if (Integer.parseInt(dailyOperations[2]) <= 0) {
            throw new RuntimeException("Incorrect amount of products in operation: "
                    + Arrays.toString(dailyOperations));
        }
        return true;
    }
}
