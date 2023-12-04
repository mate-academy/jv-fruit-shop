package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction convertDataToObject(String data) {
        String[] splitData = data.split(DATA_SEPARATOR);
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.identifyOperation(splitData[OPERATION_INDEX]);
        try {
            int quantity = Integer.parseInt(splitData[QUANTITY_INDEX]);
            return new FruitTransaction(operation,
                    splitData[FRUIT_INDEX], quantity);
        } catch (NumberFormatException e) {
            System.out.println("It is not possible to convert the string: "
                    + splitData[QUANTITY_INDEX] + " in a int type");
        }
        return null;
    }
}
