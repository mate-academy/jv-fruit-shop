package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final String FIRST_WORD = "type";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_OF_FRUITS_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : inputReport) {
            if (line.startsWith(FIRST_WORD)) {
                continue;
            }

            String[] lineParts = line.split(DELIMITER);
            validateLine(lineParts);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(lineParts[OPERATION_TYPE_INDEX]);
            transaction.setFruit(lineParts[FRUIT_NAME_INDEX]);
            transaction.setQuantity(Integer.parseInt(lineParts[QUANTITY_OF_FRUITS_INDEX]));
            transactions.add(transaction);
        }
        return transactions;
    }

    private void validateLine(String[] lineParts) {
        if (lineParts.length != QUANTITY_OF_FRUITS_INDEX + 1) {
            throw new RuntimeException(
                    "Incorrect inputReport format should be `b,banana,20` but was "
                    + Arrays.stream(lineParts).collect(Collectors.joining(DELIMITER)));
        }
    }
}
