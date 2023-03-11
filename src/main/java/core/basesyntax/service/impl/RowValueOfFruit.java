package core.basesyntax.service.impl;

import core.basesyntax.service.ValueOfFruit;

public class RowValueOfFruit implements ValueOfFruit<String[]> {
    private static final int FRUIT_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;
    private static final int ROW_SIZE = 2;

    @Override
    public String[] valueOf(String fruit, int amount) {
        String[] row = new String[ROW_SIZE];
        row[FRUIT_INDEX] = fruit;
        row[QUANTITY_INDEX] = Integer.toString(amount);
        return row;
    }
}
