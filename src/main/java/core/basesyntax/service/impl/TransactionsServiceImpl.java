package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsServiceImpl implements FruitTransactionParser {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_AMOUNT = 2;

    @Override
    public List<FruitTransaction> parse(String data) {
        String[] lines = data.split(System.lineSeparator());
        List<String[]> splited =
                Arrays.stream(lines)
                .skip(1)
                .map(line -> line
                        .trim()
                        .split(","))
                .collect(Collectors.toList());
        return fruitTransactionBuilder(splited);

    }

    private List<FruitTransaction> fruitTransactionBuilder(List<String[]> listOfString) {
        return listOfString.stream().map(splittedLine ->
                        new FruitTransaction.FruitTransactionBuilder()
                        .setOperation(FruitTransaction.Operation
                                .getOperationByLetter(splittedLine[INDEX_OF_OPERATION_TYPE]))
                        .setFruit(splittedLine[INDEX_OF_FRUIT_NAME])
                        .setQuantity(Integer.parseInt(splittedLine[INDEX_OF_AMOUNT]))
                        .build())
                        .collect(Collectors.toList());
    }

}
