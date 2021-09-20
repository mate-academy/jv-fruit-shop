package core.basesyntax.validation;

import java.util.List;

public class LineValidator implements Validator {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public void validate(List<String> checkedList) {
        if (checkedList.size() != 3) {
            throw new RuntimeException("Incorrect number of column");
        }
        if (!checkedList.get(TYPE).matches("[bspr]")) {
            throw new RuntimeException("Incorrect type of activity");
        }
        if (Integer.parseInt(checkedList.get(QUANTITY)) < 0) {
            throw new RuntimeException("Incorrect data from quantity column");
        }
    }
}
