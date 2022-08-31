package core.basesyntax.service.impl;

import core.basesyntax.service.FruitStorageService;
import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitStorageServiceImpl implements FruitStorageService {
    private static final int REPORT_HEAD_INDEX = 0;
    private static final String DATA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void process(List<String> data, Map<String, FruitOperationHandler> strategy) {
        data.remove(REPORT_HEAD_INDEX);
        String[] splitData;
        for (String dataRow : data) {
            splitData = dataRow.split(DATA_DELIMITER);
            FruitOperationHandler operation = strategy.get(splitData[OPERATION_INDEX]);
            operation.operate(splitData[FRUIT_INDEX], Integer.parseInt(splitData[AMOUNT_INDEX]));
        }
    }
}
