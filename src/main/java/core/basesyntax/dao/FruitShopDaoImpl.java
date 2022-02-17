package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operations.OperationService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    private OperationService operationService;

    @Override
    public void updateStorage(String data) {
        List<String> dataToList = Arrays.asList(data.split(System.lineSeparator()));
        dataToList.stream()
                .map(s -> s.split(","))
                .forEach(arr -> {
                    operationService = OperationStrategy
                            .getOperationType(getOperationValue(arr[0]));
                    operationService.operate(arr[1], Integer.parseInt(arr[2]));
                });
    }

    @Override
    public String getDataFromStorage() {
        StringBuilder dataFromStorage = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            dataFromStorage.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return dataFromStorage.toString();
    }

    private Operation getOperationValue(String str) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getOperation().equals(str))
                .findFirst()
                .get();
    }
}
