package core.basesyntax.shop.implementation;

import core.basesyntax.shop.Activities;
import core.basesyntax.shop.Fruit;

public class StringSplitter {
    private static final String SPLITTER_SYMBOL = ",";
    private String[] linesFromData;

    public StringSplitter(String lineFromData) {
        this.linesFromData = lineFromData.split(SPLITTER_SYMBOL);
    }

    public int getCount() {
        char[] numbers = linesFromData[2].toCharArray();
        for (char number : numbers) {
            if (!Character.isDigit(number)) {
                throw new RuntimeException("Can't get number from letters");
            }
        }
        return Integer.parseInt(linesFromData[2]);
    }

    public Fruit getFruit() {
        return new Fruit(linesFromData[1]);
    }

    public String getTypeOfOperation() {
        if (Activities.isValid(linesFromData[0])) {
            return linesFromData[0].trim().toUpperCase();
        }
        throw new RuntimeException("This type of operation is incorrect: "
                + linesFromData[0]);
    }
}
