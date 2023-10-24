package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.strategy.FruitOperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.FruitOperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.List;
import java.util.Map;

public class DataProcessServiceImpl implements DataProcessService {
    @Override
    public void processFruits(List<FruitTransaction> fruits) {
        Map<Operation, OperationHandler> operationPicker = Map.of(Operation.BALANCE,
                new BalanceOperationHandlerImpl(),
                Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(),
                Operation.RETURN,
                new ReturnOperationHandlerImpl(),
                Operation.SUPPLY,
                new SupplyOperationHandlerImpl());

        FruitOperationStrategy fruitOperationStrategy =
                new FruitOperationStrategyImpl(operationPicker);

        fruitOperationStrategy.countFruits(fruits);
    }
}
