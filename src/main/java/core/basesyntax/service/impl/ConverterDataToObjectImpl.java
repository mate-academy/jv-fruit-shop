package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterDataToObject;

public class ConverterDataToObjectImpl implements ConverterDataToObject {

    private static final String DATA_SEPARATOR = ",";

    @Override
    public FruitTransaction convertDataToObject(String data) {
        String[] splitData = data.split(DATA_SEPARATOR);
        FruitTransaction.Operation operation = identifyOperation(splitData[0]);
        return new FruitTransaction(operation, splitData[1], Integer.parseInt(splitData[2]));
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
