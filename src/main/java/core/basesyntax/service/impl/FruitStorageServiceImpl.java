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
    private final Map<String, FruitOperationHandler> handlersMap;

    public FruitStorageServiceImpl(Map<String, FruitOperationHandler> handlersMap) {
        if (handlersMap == null) {
            throw new RuntimeException("Can`t create FruitStorageServiceImpl "
                    + "with input map - null");
        }
        this.handlersMap = handlersMap;
    }

    @Override
    public void process(List<String> data) {
        data.remove(REPORT_HEAD_INDEX);
        String[] splitData;
        for (String dataRow : data) {
            splitData = dataRow.split(DATA_DELIMITER);
            FruitOperationHandler handler = handlersMap.get(splitData[OPERATION_INDEX]);
            handler.operate(splitData[FRUIT_INDEX], Integer.parseInt(splitData[AMOUNT_INDEX]));
        }
    }
}
