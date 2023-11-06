package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitConverter;
import java.util.ArrayList;
import java.util.List;

public class FruitConverterImpl implements FruitConverter {
    private static final String COMA = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] data = line.split(COMA);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.getOperationByCode(data[OPERATION]));
            fruitTransaction.setFruit(data[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
