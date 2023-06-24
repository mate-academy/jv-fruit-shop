package core.basesyntax.services.impl;

import core.basesyntax.services.DataProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingServiceImpl implements DataProcessingService {
    public static final int FRUIT_INDEX = 1;
    public static final int OPERATION_INDEX = 0;
    public static final int QUANTITY_INDEX = 2;
    private OperationStrategy operationStrategy;

    public DataProcessingServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<String[]> parcedData) {
        Map<String, Integer> resultMap = new HashMap<>();
        parcedData.forEach(transaction -> resultMap.compute(transaction[FRUIT_INDEX], (k, v) -> {
            int saldo = v == null ? 0 : v;
            return operationStrategy.getOperation(transaction[OPERATION_INDEX].toLowerCase())
                    .changeSaldo(saldo)
                    .applyAsInt(Integer.parseInt(transaction[QUANTITY_INDEX]));
        }));
        return resultMap;
    }
}
