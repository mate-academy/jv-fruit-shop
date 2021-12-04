package core.basesyntax.service;

import core.basesyntax.service.impl.StorageService;
import java.util.List;
import java.util.Map;

public class OperatePerDay {
    public OperatePerDay(List<String> operationalDay, Map<String,
            StorageService> operationStorageMap) {
        for (int i = 1; i < operationalDay.size(); i++) {
            List<String> operation;
            operation = List.of(operationalDay.get(i).split(","));
            operationStorageMap.get(operation.get(0))
                    .operateSupply(operation.get(1),Double.valueOf(operation.get(2)));
        }

    }
}
