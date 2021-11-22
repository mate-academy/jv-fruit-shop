package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Arrays;
import java.util.List;

public class ReportValidator {
    private static final String DATA_FORMAT = "[bspr],(\\w+),(\\d+)";
    private static final String TITLE = "type,fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;

    public boolean test(List<String> list) {
        if (!list.get(TITLE_INDEX).equals(TITLE)) {
            throw new RuntimeException("Invalid data in input file - missing title line");
        }
        for (int i = 1; i < list.size(); i++) {
            String line = list.get(i);
            String[] values = line.split(",");
            if (!(line.trim().matches(DATA_FORMAT)
                    && checkFruitName(values[FRUIT_NAME_INDEX]))) {
                throw new RuntimeException("Invalid data in input file");
            }
        }
        return true;
    }

    private boolean checkFruitName(String fruitName) {
        return Arrays.stream(Fruit.values()).anyMatch(e -> e.getName().equals(fruitName));
    }
}
