package core.basesyntax.service.impl;

import core.basesyntax.model.OperationFruitDto;
import core.basesyntax.operationstrategy.OperationService;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.service.ParseValidData;

public class ParseValidDataImpl implements ParseValidData {
    @Override
    public OperationFruitDto parseValidDataImpl(String stringFromFile) {
        String[] strings = stringFromFile.split(",");
        OperationService operationService = OperationStrategy
                .MAP_OPERATION.get(strings[CheckDataValidationImpl.OPERATION_INDEX]);
        return new OperationFruitDto(operationService,
                          strings[CheckDataValidationImpl.FRUIT_INDEX],
                          Integer.parseInt(strings[CheckDataValidationImpl.QUANTITY_INDEX]));
    }
}
