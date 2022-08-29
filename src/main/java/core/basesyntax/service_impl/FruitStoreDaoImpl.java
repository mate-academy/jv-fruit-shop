package core.basesyntax.service_impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.FruitStoreDao;
import core.basesyntax.strategy.FruitOperation;

import java.util.List;
import java.util.Map;

public class FruitStoreDaoImpl implements FruitStoreDao {
    private static final String DATA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void process(List<String> data, Map<String, FruitOperation> strategy, StorageDao storageDao) {
        String[] splitData;
        for (String dataRow : data) {
            splitData = dataRow.split(DATA_DELIMITER);
            FruitOperation operation = strategy.get(splitData[OPERATION_INDEX]);
            operation.operate(splitData[FRUIT_INDEX], Integer.parseInt(splitData[AMOUNT_INDEX]), storageDao);
        }
    }
}
