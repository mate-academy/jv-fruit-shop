package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String REGEX = ",";
    private static final int INDEX_CODE_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY_OPERATION = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputFile) {
        if (inputFile == null || inputFile.isEmpty() || inputFile.size() <= 1) {
            return List.of();
        }
        return inputFile.stream()
                .skip(1)
                .map(fileLine -> fileLine.split(REGEX))
                .map(splits -> new FruitTransaction(Operation
                        .operationFromCode(splits[INDEX_CODE_OPERATION]),
                        splits[INDEX_FRUIT],
                        Integer.parseInt(splits[INDEX_QUANTITY_OPERATION])))
                .toList();
    }
}
