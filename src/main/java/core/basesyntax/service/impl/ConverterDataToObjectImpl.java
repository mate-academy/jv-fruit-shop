package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterDataToObject;

public class ConverterDataToObjectImpl implements ConverterDataToObject {

    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction convertDataToObject(String data) {
        String[] splitData = data.split(DATA_SEPARATOR);
        FruitTransaction.Operation operation = identifyOperation(splitData[OPERATION_INDEX]);
        return new FruitTransaction(operation, splitData[FRUIT_INDEX],
                Integer.parseInt(splitData[QUANTITY_INDEX]));
    }

    private FruitTransaction.Operation identifyOperation(String codeOperation) {
        FruitTransaction.Operation[] operations = FruitTransaction.Operation.values();
        for (FruitTransaction.Operation operation : operations) {
            if (operation.getCode().equals(codeOperation)) {
                return operation;
            }
        }
        return null;
    }
}
