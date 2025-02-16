package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverterMet {
    private final String comma = ",";
    private final int requiredArrayLength = 3;
    private final int operationIndex = 0;
    private final int nameIndex = 1;
    private final int quantityIndex = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readedFruits) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String fruit : readedFruits) {
            String[] fruitInArr = fruit.split(comma);

            if (fruitInArr.length != requiredArrayLength) {
                throw new RuntimeException("Array length must be 3");
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(fruitInArr[operationIndex]);
            String name = fruitInArr[nameIndex];
            int quantity;

            try {
                quantity = Integer.parseInt(fruitInArr[quantityIndex]);
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
