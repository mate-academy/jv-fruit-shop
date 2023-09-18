package core.basesyntax.storage;

import core.basesyntax.model.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private static final int OPERATION_TYPE_INDEX = 0;
    private final PrepareList prepareList = new PrepareList();
    private final ProcessingData processingData = new ProcessingData();
    private final Map<Operation, Map<String, List<Integer>>> fruitMaps = new HashMap<>();

    public Map<Operation, Map<String, List<Integer>>> createStorage() {
        for (String rowFromOperationList : prepareList.preparedListWithoutTitle()) {
            String[] split = rowFromOperationList.split(",");
            String operationType = split[OPERATION_TYPE_INDEX];
            processingData.recognitionData(fruitMaps,operationType,rowFromOperationList);
        }
        return fruitMaps;
    }
}
