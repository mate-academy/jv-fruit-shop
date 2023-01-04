package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsListService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransactionsListServiceImpl implements TransactionsListService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMMA_DELIMITER = ",";

    @Override
    public List<FruitTransaction> getTransactionsList(String data) {
        String[] splitLines = data.split(System.lineSeparator());
        return IntStream.range(1, splitLines.length)
                .mapToObj(i -> splitLines[i]
                        .trim().split(COMMA_DELIMITER))
                .map(splittedLine -> new FruitTransaction.FruitTransactionBuilder()
                .setOperation(FruitTransaction.Operation
                        .getOperationByLetter(splittedLine[OPERATION_TYPE_INDEX]))
                .setFruit(splittedLine[FRUIT_TYPE_INDEX])
                .setQuantity(Integer.parseInt(splittedLine[AMOUNT_INDEX]))
                .build())
                .collect(Collectors.toList());
    }
}
