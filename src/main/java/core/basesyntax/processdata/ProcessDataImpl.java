package core.basesyntax.processdata;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.operationstrategy.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessData {
    private static final int OPERATION_TYPE_POSITION = 0;
    private static final int ITEM_NAME_POSITION = 1;
    private static final int ITEM_VALUE_POSITION = 2;
    private final OperationStrategy operationStrategy;
    private final StorageDao storageDao;

    public ProcessDataImpl(Map<Character, OperationHandler> operationHandlerMap) {
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        storageDao = new StorageDaoImpl();
    }

    @Override
    public Map<String, Integer> process(List<List<String>> processedData) {
        for (List<String> dataLine : processedData) {
            Character operationType = dataLine.get(OPERATION_TYPE_POSITION).charAt(0);
            String itemName = dataLine.get(ITEM_NAME_POSITION);
            Integer value = Integer.parseInt(dataLine.get(ITEM_VALUE_POSITION));
            operationStrategy.get(operationType).processOperation(itemName, value);
        }
        return storageDao.getStock();
    }
}
