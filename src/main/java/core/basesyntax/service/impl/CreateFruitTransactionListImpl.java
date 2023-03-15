package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.CreateFruitTransactionList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateFruitTransactionListImpl implements CreateFruitTransactionList {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> create(List<String> strings) {
        return strings.stream()
                .skip(1)
                .map(s -> transform(s.trim()))
                .collect(Collectors.toList());
    }

    private FruitTransaction transform(String line) {
        String[] lineSplit = line.split(SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperation(lineSplit[OPERATION_INDEX]));
        fruitTransaction.setFruit(lineSplit[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(lineSplit[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
