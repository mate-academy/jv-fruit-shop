package core.basesyntax.service.impl;

import core.basesyntax.model.OperationFruitDto;
import core.basesyntax.service.Parser;

public class ParserImpl implements Parser {
    @Override
    public OperationFruitDto parse(String stringFromFile) {
        String[] strings = stringFromFile.split(",");
        String operation = strings[DataValidatorImpl.OPERATION_INDEX];
        return new OperationFruitDto(operation,
                          strings[DataValidatorImpl.FRUIT_INDEX],
                          Integer.parseInt(strings[DataValidatorImpl.QUANTITY_INDEX]));
    }
}
