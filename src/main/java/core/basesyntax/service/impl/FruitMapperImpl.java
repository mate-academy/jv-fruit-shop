package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitMapper;
import java.util.ArrayList;
import java.util.List;

public class FruitMapperImpl implements FruitMapper {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> mapData(List<String> list) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        list.remove(0);
        for (String item : list) {
            String[] data = item.split(SPLIT_REGEX);
            String operation = data[OPERATION_INDEX];
            String fruitType = data[FRUIT_INDEX];
            int quantity = Integer.parseInt(data[FRUIT_QUANTITY_INDEX]);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(Operation.getOperationValue(operation));
            fruitTransaction.setFruit(fruitType);
            fruitTransaction.setQuantity(quantity);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
