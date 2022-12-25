package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int ACTIVITIES_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COLUMNS_SEPARATOR = ",";

    public List<FruitTransaction> getFruitTransactionsList(List<String> dataFromCsvInput) {
        return dataFromCsvInput.stream()
                .skip(1)
                .map(this::createFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String fieldsFromLine) {
        String[] arrayFieldsFromLine = fieldsFromLine.split(COLUMNS_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(arrayFieldsFromLine[ACTIVITIES_TYPE_INDEX]));
        fruitTransaction.setFruit(arrayFieldsFromLine[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(arrayFieldsFromLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
