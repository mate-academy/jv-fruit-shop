package service;

import dto.Transaction;
import model.Fruit;

public class FruitParser {
    public static final int OPERATION = 0;
    public static final int FRUIT = 1;
    public static final int QUALITY = 2;
    public static final String COMMA = ",";

    public Transaction parseData(String data) {
        String[] parseData = data.split(COMMA);
        return new Transaction(parseData[OPERATION],
                new Fruit(parseData[FRUIT]),
                Integer.parseInt(parseData[QUALITY]));
    }
}
