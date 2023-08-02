package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileConverter;
import java.util.List;
import java.util.stream.Collectors;

public class FileConverterImpl implements FileConverter {
    private static final String COMMA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToObjects(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseFruitTransaction(String line) {
        String[] partsOfData = line.split(COMMA_SEPARATOR);
        if (partsOfData.length != 3) {
            throw new IllegalArgumentException("Invalid input parameters:" + line);
        }
        String operation = partsOfData[OPERATION_INDEX];
        String type = partsOfData[TYPE_INDEX];
        int quantity = Integer.parseInt(partsOfData[QUANTITY_INDEX]);

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.getOption(operation));
        fruitTransaction.setFruit(type);
        fruitTransaction.setQuantity(quantity);
        return fruitTransaction;
    }
}
