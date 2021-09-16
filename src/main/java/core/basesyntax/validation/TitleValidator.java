package core.basesyntax.validation;

import java.util.List;

public class TitleValidator implements Validator {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String TYPE_NAME = "type";
    private static final String FRUIT_NAME = "fruit";
    private static final String QUANTITY_NAME = "quantity";

    @Override
    public void validate(List<String> checkedList) {
        if (checkedList.size() != 3) {
            throw new RuntimeException("Incorrect number of column");
        }
        if (!checkedList.get(TYPE).equals(TYPE_NAME)
                || !checkedList.get(FRUIT).equals(FRUIT_NAME)
                || !checkedList.get(QUANTITY).equals(QUANTITY_NAME)) {
            throw new RuntimeException("Incorrect name in title");
        }
    }
}
