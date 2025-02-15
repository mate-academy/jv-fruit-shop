package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverterMet {
    private final int OPERATION_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readedFruits) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String fruit : readedFruits) {
            String[] fruitInArr = fruit.split(",");

            if (fruitInArr.length != 3) {
                throw new RuntimeException("Array length must be 3");
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(fruitInArr[OPERATION_INDEX]);
            String name = fruitInArr[NAME_INDEX];
            int quantity;

            try {
                quantity = Integer.parseInt(fruitInArr[QUANTITY_INDEX]);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Quantity must be a number", e);
            }

            if (quantity < 0) {
                throw new RuntimeException("Quantity must be greater than 0");
            }

            result.add(new FruitTransaction(operation, name, quantity));
        }
        return result;
    }
}
