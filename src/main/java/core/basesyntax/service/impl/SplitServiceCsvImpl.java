package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.SplitService;
import java.util.Arrays;

public class SplitServiceCsvImpl implements SplitService {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public FruitTransaction getTransactionFromRow(String line) {
        String[] splitData = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Arrays.stream(FruitTransaction.Operation.values())
                .filter(o -> o.getOperation().equals(splitData[TYPE]))
                .findFirst()
                .get());
        fruitTransaction.setFruit(splitData[FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(splitData[QUANTITY]));
        return fruitTransaction;
    }
}
