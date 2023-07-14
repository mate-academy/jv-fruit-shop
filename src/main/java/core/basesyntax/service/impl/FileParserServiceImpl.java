package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;
import java.util.ArrayList;
import java.util.List;

public class FileParserServiceImpl implements FileParserService {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int MIN_QUANTITY_VALUE = 0;

    private FruitOperation[] fruitOperations
            = FruitOperation.values();

    @Override
    public List<FruitTransaction> parseFile(String[] fileContent) {
        if (fileContent == null) {
            throw new RuntimeException("FileContent can't be null");
        }
        List<FruitTransaction> fruitTransactionList = new ArrayList<>(fileContent.length);
        for (String fileLine : fileContent) {
            String[] valuesFromFileLine = fileLine.split(",");
            int quantityValue = Integer.parseInt(valuesFromFileLine[INDEX_OF_QUANTITY]);
            if (quantityValue < MIN_QUANTITY_VALUE) {
                throw new RuntimeException("Quantity must be not less than " + MIN_QUANTITY_VALUE);
            }
            fruitTransactionList.add(new FruitTransaction(
                    getOperationFromCode(valuesFromFileLine[INDEX_OF_OPERATION]),
                    valuesFromFileLine[INDEX_OF_FRUIT_NAME],
                    quantityValue));
        }
        return fruitTransactionList;
    }

    private FruitOperation getOperationFromCode(String operationCode) {
        for (FruitOperation fruitOperation : fruitOperations) {
            if (fruitOperation.getCode().equals(operationCode)) {
                return fruitOperation;
            }
        }
        throw new RuntimeException("Unknown operation code: " + operationCode);
    }
}
