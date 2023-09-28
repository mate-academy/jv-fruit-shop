package core.basesyntax.storage;

import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final String SEPARATOR = ",";
    private final ProcessingData processingData;

    public FruitStorage(ProcessingData processingData) {
        this.processingData = processingData;
    }

    public Map<Operation, Map<String, List<Integer>>> createStorage(Map<Operation, Map<String,
            List<Integer>>> fruitMaps, List<String> listOperation) {
        for (String rowFromOperationList : listOperation) {
            String[] split = rowFromOperationList.split(SEPARATOR);
            String operationType = split[OPERATION_TYPE_INDEX];
            processingData.recognitionData(fruitMaps,operationType,rowFromOperationList);
        }
        return fruitMaps;
    }
}
