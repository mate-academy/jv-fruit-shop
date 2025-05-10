package core.basesyntax.service.convertator;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConvertorImpl implements DataConvertor {
    private static final int INDEX_TYPE_OPERATION = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String SPLIT_REGEX = ",";
    private static final Integer SKIP_FIRST_LINE_FROM_DATA = 1;

    @Override
    public List<FruitTransaction> convertData(String data) {
        List<FruitTransaction> convertedData = new ArrayList<>();

        for (String fruit : Arrays.stream(data.split(System.lineSeparator()))
                .skip(SKIP_FIRST_LINE_FROM_DATA)
                .toList()) {
            convertedData.add(new FruitTransaction(convertOperation(fruit
                    .split(SPLIT_REGEX)[INDEX_TYPE_OPERATION]),
                    fruit.split(SPLIT_REGEX)[INDEX_FRUIT_NAME],
                    Integer.parseInt(fruit.split(SPLIT_REGEX)[INDEX_QUANTITY])));
        }
        return convertedData;
    }

    private FruitTransaction.Operation convertOperation(String inputOperation) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getNameOperation().equalsIgnoreCase(inputOperation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + inputOperation);
    }
}
