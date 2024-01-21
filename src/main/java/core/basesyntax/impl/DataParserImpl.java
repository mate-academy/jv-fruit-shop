package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        for (String line: dataFromFile) {
            String[] lineData = line.split(SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getOperationByCode(lineData[OPERATION_INDEX]);
            String fruit = lineData[FRUIT_INDEX];
            int amount = Integer.parseInt(lineData[AMOUNT_INDEX]);
            transactionsList.add(new FruitTransaction(operation, fruit, amount));
        }
        return transactionsList;
    }
}
