package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.FruitTransactionMap;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionMapImpl implements FruitTransactionMap {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int WEIGHT_INDEX = 2;
    private static final String COMA = ",";

    @Override
    public List<ShopTransaction> map(List<String> dataFromFile) {
        List<ShopTransaction> shopTransactionList = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String[] record = dataFromFile.get(i).split(COMA);
            String activity = record[OPERATION_INDEX];
            String fruit = record[FRUIT_INDEX];
            int weight = Integer.parseInt(record[WEIGHT_INDEX]);
            shopTransactionList.add(
                    new ShopTransaction(OperationType.getOperationType(activity), fruit, weight));
        }
        return shopTransactionList;
    }
}
