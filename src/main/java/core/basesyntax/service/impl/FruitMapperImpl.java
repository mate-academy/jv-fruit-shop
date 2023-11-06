package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitMapper;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {
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
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationByCode(data[OPERATION]));
            fruitTransaction.setFruit(data[FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[QUANTITY]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
