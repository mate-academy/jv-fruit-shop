package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class FruitParser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT = 1;
    public static final int QUALITY = 2;
    public static final String COMMA = ",";
    public static final Validator validator = new ValidatorImpl();

    public Transaction parseData(String data) {
        String[] parseData = data.split(COMMA);
        return new Transaction(ValidatorImpl.findOperation(parseData[OPERATION_INDEX]),
                new Fruit(parseData[FRUIT]),
                Integer.parseInt(parseData[QUALITY]));
    }
}
