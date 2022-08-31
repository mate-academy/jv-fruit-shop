package core.basesyntax.service.impl;

import core.basesyntax.service.FruitStorageService;
import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitStorageServiceImpl implements FruitStorageService {
    private static final String REPORT_HEAD_MESSAGE = "type,fruit,quantity";
    private static final int REPORT_HEAD_INDEX = 0;
    private static final String DATA_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final Map<String, FruitOperationHandler> handlersMap;

    public FruitStorageServiceImpl(Map<String, FruitOperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public void process(List<String> data) {
        if (handlersMap == null) {
            throw new RuntimeException("Can`t call method 'process' if handlersMap is null");
        }
        if (data == null || data.size() == 0) {
            throw new RuntimeException("Can't process data because input data is null or empty");
        }
        if (data.get(0).equals(REPORT_HEAD_MESSAGE)) {
            data.remove(REPORT_HEAD_INDEX);
        }
        String[] splitData;
        for (String dataRow : data) {
            splitData = dataRow.split(DATA_DELIMITER);
            FruitOperationHandler handler = handlersMap.get(splitData[OPERATION_INDEX]);
            if (handler == null) {
                throw new RuntimeException("Input data is incorrect");
            }
            handler.operate(splitData[FRUIT_INDEX], Integer.parseInt(splitData[AMOUNT_INDEX]));
        }
    }
}
