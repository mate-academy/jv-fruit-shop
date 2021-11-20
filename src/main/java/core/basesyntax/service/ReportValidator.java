package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Arrays;
import java.util.function.Predicate;

public class ReportValidator implements Predicate<String> {
    private static final String DATA_FORMAT = "\\S,(\\w+),(\\d+)";
    private static final int FRUIT_NAME_INDEX = 1;

    @Override
    public boolean test(String line) {
        String[] values = line.split(",");
        if (!(line.trim().matches(DATA_FORMAT)
                && checkFruitName(values[FRUIT_NAME_INDEX]))) {
            throw new RuntimeException("Invalid data in input file");
        }
        return true;
    }

    private boolean checkFruitName(String fruitName) {
        return Arrays.stream(Fruit.values()).anyMatch(e -> e.getName().equals(fruitName));
    }
}
