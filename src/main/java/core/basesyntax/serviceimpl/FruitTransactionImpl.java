package core.basesyntax.serviceimpl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.FruitOperation;
import java.util.List;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int REPORT_HEAD_INDEX = 0;
    private static final String DATA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void process(List<String> data, Map<String, FruitOperation> strategy,
                        StorageDao storageDao) {
        data.remove(REPORT_HEAD_INDEX);
        String[] splitData;
        for (String dataRow : data) {
            splitData = dataRow.split(DATA_DELIMITER);
            FruitOperation operation = strategy.get(splitData[OPERATION_INDEX]);
            operation.operate(splitData[FRUIT_INDEX], Integer.parseInt(splitData[AMOUNT_INDEX]),
                    storageDao);
        }
    }
}
