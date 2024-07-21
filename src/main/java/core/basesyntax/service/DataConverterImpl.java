package core.basesyntax.service;

import core.basesyntax.domain.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverterService {
    private static final String COMMA_DELIMITER = ",";
    private static final int COUNT_HEADER_LINES_TO_SKIP = 1;
    private static final int FRUIT_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToFruit(List<String> inputReport) {
        return inputReport.stream()
                .skip(COUNT_HEADER_LINES_TO_SKIP)
                .map(this::convertToFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToFruitTransaction(String line) {
        String[] splitFruits = line.split(COMMA_DELIMITER);
        FruitTransaction.Operation fruitOperation =
                FruitTransaction.Operation.getByCode(splitFruits[FRUIT_OPERATION_INDEX]);
        FruitTransaction.FruitName fruitName =
                FruitTransaction.FruitName.getByFruitName(splitFruits[FRUIT_NAME_INDEX]);
        int fruitQuantity = Integer.parseInt(splitFruits[FRUIT_QUANTITY_INDEX]);
        return new FruitTransaction(fruitOperation, fruitName, fruitQuantity);
    }
}
