package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitParserImpl implements FruitParser {
    private static final String REGEX = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseData(String dataFromFile) {
        return Arrays
                .stream(dataFromFile.split(System.lineSeparator()))
                .skip(1)
                .map(this::createFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String data) {
        String[] splitedData = data.split(REGEX);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getOperation(splitedData[INDEX_OPERATION]));
        fruitTransaction.setFruit(splitedData[INDEX_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(splitedData[INDEX_QUANTITY]));
        return fruitTransaction;
    }
}
