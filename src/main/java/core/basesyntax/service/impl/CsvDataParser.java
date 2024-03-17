package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.ReadDataParser;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser implements ReadDataParser {
    private static final String LINE_SPLIT_REGEX = ",";
    private static final int OPERATION_TYPE_CODE_INDEX = 0;
    private static final int PRODUCT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parseToTransactionList(List<String> readData) {
        int firsDataLineIndex = 1;
        List<FruitTransaction> resultList = new ArrayList<>();

        for (int i = firsDataLineIndex; i < readData.size(); i++) {
            String[] splitLine = readData.get(i).split(LINE_SPLIT_REGEX);
            resultList.add(new FruitTransaction(parseOperationType(splitLine),
                    parseProductType(splitLine), parseAmount(splitLine)));
        }
        return resultList;
    }

    private int parseAmount(String[] splitLine) {
        return Integer.parseInt(splitLine[AMOUNT_INDEX]);
    }

    private String parseProductType(String[] splitLine) {
        return splitLine[PRODUCT_TYPE_INDEX];
    }

    private Operation parseOperationType(String[] splitLine) {
        return Operation.fromCode(splitLine[OPERATION_TYPE_CODE_INDEX].trim());
    }
}
