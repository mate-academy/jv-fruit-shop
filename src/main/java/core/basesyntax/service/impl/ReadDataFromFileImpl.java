package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReadDataFromFile;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction readDataFromfile(String csvLine) {
        String[] parts = csvLine.split(",");
        Operation operation = Operation.getByCode(parts[OPERATION_INDEX]);
        String fruit = parts[FRUIT_INDEX];
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
