package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
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
        String[] strings = data.split(DELIMITER);
        Fruit newFruit = new Fruit(strings[NAME_INDEX], Integer.parseInt(strings[QUANTITY_INDEX]));
        Operation operation = Operation
                .fromCode(strings[OPERATION_INDEX]);
        return new FruitTransaction(operation, newFruit);
    }
}
