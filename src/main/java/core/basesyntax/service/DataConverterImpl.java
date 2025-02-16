package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverterMethods {
    private static final String COMMA = ",";
    private static final int REQUIRED_ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readedFruits) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String fruit : readedFruits) {
            String[] fruitInArr = fruit.split(COMMA);

            if (fruitInArr.length != REQUIRED_ARRAY_LENGTH) {
                throw new RuntimeException("Array length must be 3: " + fruitInArr);
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(fruitInArr[OPERATION_INDEX]);
            String name = fruitInArr[NAME_INDEX];
            int quantity = 0;

            try {
                quantity = Integer.parseInt(fruitInArr[QUANTITY_INDEX]);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Quantity must be a number: " + quantity, e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity must be greater than 0: " + quantity);
            }

            result.add(new FruitTransaction(operation, name, quantity));
        }
        return result;
    }
}
