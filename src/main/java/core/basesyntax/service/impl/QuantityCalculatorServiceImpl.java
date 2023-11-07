package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.QuantityCalculatorService;
import java.util.List;
import java.util.Map;

public class QuantityCalculatorServiceImpl implements QuantityCalculatorService {
    private Map<Operation, OperationHandler> operationMap;

    public QuantityCalculatorServiceImpl(Map<Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void calcualteQuantityForFruits(List<FruitTransaction> fruitTransactions) {
        fruitTransactions
                .forEach(fruitTransaction -> operationMap.get(fruitTransaction.getOperation())
                        .calculateQuantity(fruitTransaction));
    }
}
