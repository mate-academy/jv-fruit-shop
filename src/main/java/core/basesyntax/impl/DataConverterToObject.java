package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterToObject implements DataConverter {
    private static final int INDEX_OF_INFO = 0;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String COMMA = ",";

    public List<FruitTransaction> convert(List<String> inputData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        inputData.remove(INDEX_OF_INFO);
        for (String data : inputData) {
            String[] dataToProcess = data.trim().split(COMMA);
            transactions.add(new FruitTransaction(Operation
                    .convertToOperation(dataToProcess[INDEX_OF_OPERATION]),
                    dataToProcess[INDEX_OF_FRUIT],
                    Integer.parseInt(dataToProcess[INDEX_OF_QUANTITY])));
        }
        return transactions;
    }
}
