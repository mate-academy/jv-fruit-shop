package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionMapper;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser implements FruitTransactionMapper {
    private static final String LINE_SPLIT_REGEX = ",";
    private static final int OPERATION_TYPE_CODE_INDEX = 0;
    private static final int PRODUCT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int FIRS_DATA_LINE_INDEX = 1;

    @Override
    public List<FruitTransaction> map(List<String> data) {
        List<FruitTransaction> resultList = new ArrayList<>();

        for (int i = FIRS_DATA_LINE_INDEX; i < data.size(); i++) {
            String[] splitLine = data.get(i).split(LINE_SPLIT_REGEX);
            Operation operationType = parseOperationType(splitLine);
            String productType = parseProductType(splitLine);
            int amount = parseAmount(splitLine);
            FruitTransaction newTransaction = new FruitTransaction(operationType, productType,
                                                                                        amount);
            resultList.add(newTransaction);
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
