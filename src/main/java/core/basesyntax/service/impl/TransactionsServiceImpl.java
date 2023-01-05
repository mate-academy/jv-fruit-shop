package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsServiceImpl implements TransactionsService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMMA_DELIMITER = ",";

    @Override
    public List<FruitTransaction> getTransactions(String data) {
        String[] lines = data.split(System.lineSeparator());
        return Arrays.stream(lines)
                .skip(1)
                .map(line -> line.trim().split(COMMA_DELIMITER))
                .map(splitLine -> new FruitTransaction.FruitTransactionBuilder()
                .setOperation(FruitTransaction.Operation
                        .getOperationByLetter(splitLine[OPERATION_TYPE_INDEX]))
                .setFruit(splitLine[FRUIT_TYPE_INDEX])
                .setQuantity(Integer.parseInt(splitLine[AMOUNT_INDEX]))
                .build())
                .collect(Collectors.toList());
    }
}
