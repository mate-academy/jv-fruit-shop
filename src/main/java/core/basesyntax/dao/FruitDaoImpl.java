package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operations.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final String SEPARATOR = ",";
    private OperationHandler operationService;

    @Override
    public void updateStorage(List<String[]> data) {
        data.forEach(arr -> {
            operationService = OperationStrategy
                    .getOperationType(Operation.getOperationValue(arr[0]));
            operationService.operate(arr[1], Integer.parseInt(arr[2]));
        });
    }

    @Override
    public String getDataFromStorage() {
        StringBuilder dataFromStorage = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            dataFromStorage.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return dataFromStorage.toString();
    }

}
