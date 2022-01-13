package core.basesyntax.service.impl;

import core.basesyntax.model.OperationFruitDto;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public OperationFruitDto parse(String stringFromFile) {
        String[] strings = stringFromFile.split(",");
        String operation = strings[OPERATION_INDEX];
        return new OperationFruitDto(operation,
                          strings[FRUIT_INDEX],
                          Integer.parseInt(strings[QUANTITY_INDEX]));
    }
}
