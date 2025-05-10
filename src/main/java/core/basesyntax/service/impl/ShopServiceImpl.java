package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Report;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Report process(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        boolean isInitialization = true;
        for (FruitTransaction transaction : transactions) {
            isInitialization = ensureBalanceInitialization(isInitialization,
                    transaction.getOperation());
            OperationHandler handler = strategy.getHandler(transaction.getOperation());
            handler.process(fruitQuantityMap, transaction);
        }
        return new Report(fruitQuantityMap);
    }

    private boolean ensureBalanceInitialization(boolean isInitialization, Operation operation) {
        if (!isInitialization && operation == Operation.BALANCE) {
            throw new IllegalStateException("Operation = ["
                    + operation + "] can be present only in the beginning");
        }
        if (isInitialization && operation != Operation.BALANCE) {
            isInitialization = false;
        }
        return isInitialization;
    }
}
