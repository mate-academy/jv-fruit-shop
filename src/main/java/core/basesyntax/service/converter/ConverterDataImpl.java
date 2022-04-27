package core.basesyntax.service.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ConverterDataImpl implements ConverterData {
    private static final int INDEX_TYPE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> getFruitsOperation(List<String> list) {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (String string : list) {
            String[] data = string.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.getType(data[INDEX_TYPE]));
            fruitTransaction.setFruit(data[INDEX_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(data[INDEX_QUANTITY]));
            fruits.add(fruitTransaction);
        }
        return fruits;
    }
}
