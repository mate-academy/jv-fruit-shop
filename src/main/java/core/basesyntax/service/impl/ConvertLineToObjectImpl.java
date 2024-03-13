package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertLineToObject;

public class ConvertLineToObjectImpl implements ConvertLineToObject {
    public static final String LINE_SEPARATOR = ";";
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_FRUIT = 1;
    public static final int INDEX_OF_QUANTITY = 2;

    @Override
    public FruitTransaction getData(String line) {
        if (line == null) {
            throw new RuntimeException("Line is empty");
        }
        if (!line.contains(LINE_SEPARATOR)) {
            throw new RuntimeException("Line doesn't have column separators");
        }
        String[] dataFromLine = line.split(LINE_SEPARATOR);
        return new FruitTransaction(
                FruitTransaction.Operation.fromCode(dataFromLine[INDEX_OF_OPERATION]),
                dataFromLine[INDEX_OF_FRUIT],
                Integer.parseInt(dataFromLine[INDEX_OF_QUANTITY]));
    }
}
