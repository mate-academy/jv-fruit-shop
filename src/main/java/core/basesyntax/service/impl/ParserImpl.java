package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction parse(String data) {
        if (!data.matches("^[brsp],.*")) {
            return null;
        }
        String[] strings = data.split(DELIMITER);
        String fruitName = strings[NAME_INDEX];
        int quantity = Integer.parseInt(strings[QUANTITY_INDEX]);
        Operation operation = Operation
                .fromCode(strings[OPERATION_INDEX]);
        return new FruitTransaction(operation, fruitName, quantity);
    }
}
