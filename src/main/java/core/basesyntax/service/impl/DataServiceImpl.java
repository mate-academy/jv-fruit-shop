package core.basesyntax.service.impl;

import core.basesyntax.service.DataService;
import core.basesyntax.service.OperationSelector;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.strategy.OperationStrategyImpl;

public class DataServiceImpl implements DataService {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;

    public void proceedData(String line) {
        OperationValidator operationValidator = new OperationValidatorImpl();
        String[] dataToProceed = line.split(DATA_SEPARATOR);
        if (operationValidator.isValidOperation(dataToProceed[OPERATION_TYPE])) {
            OperationSelector operationSelector = new OperationStrategyImpl()
                        .get(dataToProceed[OPERATION_TYPE]);
            operationSelector.valueOperation(dataToProceed[FRUIT_TYPE],
                        Integer.parseInt(dataToProceed[QUANTITY]));
        }
    }
}
