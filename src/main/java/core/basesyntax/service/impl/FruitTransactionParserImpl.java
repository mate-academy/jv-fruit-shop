package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int FIELDS_COUNT = 3;
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getFruitTransactionsList(List<String> readData) {
        return readData.stream()
                .map(s -> s.split(SPLITTER))
                .filter(a -> a.length == FIELDS_COUNT
                && getOperationsNames().contains(a[OPERATION_INDEX]))
                .map(s -> createFruitTransaction(s))
                .collect(Collectors.toList());
    }

    private FruitTransaction createFruitTransaction(String[] transactionData) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getBySymbol(transactionData[OPERATION_INDEX]));
        fruitTransaction.setFruit(transactionData[FRUIT_NAME_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(transactionData[AMOUNT_INDEX]));
        return fruitTransaction;
    }

    private List<String> getOperationsNames() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(o -> o.getOperation())
                .collect(Collectors.toList());
    }
}
