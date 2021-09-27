package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.inter.FruitShopService;
import core.basesyntax.service.inter.Operation;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void updateStorageInfo(List<FruitOperation> operations,
                                  Map<String, Operation> operationsHandlers) {
        operations.forEach(fruitOperation -> {
            Operation operation = operationsHandlers.get(fruitOperation.getType());
            operation.apply(fruitOperation);
        });
    }
}
