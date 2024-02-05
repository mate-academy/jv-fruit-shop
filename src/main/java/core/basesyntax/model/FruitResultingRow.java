package core.basesyntax.model;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FruitResultingRow {
    private final String fruit;
    private final int quantity;

    public FruitResultingRow(String fruitName, int fruitCount) {
        this.fruit = fruitName;
        this.quantity = fruitCount;
    }

    public String toCsv() {
        return fruit + "," + quantity;
    }

    public static String getFieldsForCsvHeaderRow() {
        StringBuilder b = new StringBuilder();
        Field[] fields = FruitResultingRow.class.getDeclaredFields();
        Arrays.stream(fields)
                .forEach(f -> b.append(f.getName()).append(","));

        b.deleteCharAt(b.length() - 1); // remove last comma, dont need  it
        return b.toString();
    }

    @Override
    public String toString() {
        return "FruitResultingRow{"
                + "fruitName='" + fruit
                + ", fruitCount=" + quantity
                + '}';
    }
}
