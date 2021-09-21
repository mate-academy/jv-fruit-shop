package core.basesyntax.services.impl;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.Parser;
import core.basesyntax.services.Validator;

public class ParserImpl implements Parser {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT = 1;
    public static final int QUALITY = 2;
    public static final String COMMA = ",";

    @Override
    public Transaction parseData(String data) {
        String[] parseData = data.split(COMMA);
        Validator validator = new ValidatorImpl();
        return new Transaction(validator.findOperation(parseData[OPERATION_INDEX]),
                new Fruit(parseData[FRUIT]), Integer.parseInt(parseData[QUALITY]));
    }
}
