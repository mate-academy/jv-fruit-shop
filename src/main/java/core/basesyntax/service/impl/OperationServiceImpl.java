package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.OperationMap;
import core.basesyntax.service.OperationService;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationMap operationMap;

    public OperationServiceImpl(OperationMap operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void processData(List<FruitShopTransactions> fruitShopTransactions) {
        fruitShopTransactions.forEach(f -> operationMap
                        .get(f.getOperation())
                        .makeOperation(f));
    }
}
