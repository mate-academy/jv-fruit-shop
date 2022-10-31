package core.basesyntax.service.impl;

import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionData;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDataImpl implements FruitTransactionData {
    private static final String STRING_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseDataFromFile(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        dataFromFile.stream()
                .skip(1)
                .map(String::trim)
                .map(i -> i.split(STRING_SEPARATOR))
                .forEach(i -> fruitTransactions
                        .add(new FruitTransaction(Operation
                                .getFromEqualString(i[OPERATION_INDEX]),
                                i[FRUIT_TYPE_INDEX], Integer.parseInt(i[2]))));
        return fruitTransactions;
    }
}
