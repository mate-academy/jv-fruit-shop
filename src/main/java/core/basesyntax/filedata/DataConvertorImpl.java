package core.basesyntax.filedata;

import core.basesyntax.model.FruitTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConvertorImpl implements DataConvertor {
    private static final String SPLIT_ELEMENT = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertData(String[] dataArray) {
        return Arrays.stream(dataArray)
                .map(this::parseFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseFruitTransaction(String dataItem) {
        return new FruitTransaction(getOperationType(dataItem),
                getFruitType(dataItem), getQuantity(dataItem));
    }

    private FruitTransaction.Operation getOperationType(String dataString) {
        String[] inputData = dataString.split(SPLIT_ELEMENT);
        return FruitTransaction.Operation.valueOfCode(inputData[OPERATION]);
    }

    private String getFruitType(String dataString) {
        String[] inputData = dataString.split(SPLIT_ELEMENT);
        return inputData[FRUIT_TYPE];
    }

    private int getQuantity(String dataString) {
        String[] inputData = dataString.split(SPLIT_ELEMENT);
        return Integer.parseInt(inputData[QUANTITY]);
    }
}
