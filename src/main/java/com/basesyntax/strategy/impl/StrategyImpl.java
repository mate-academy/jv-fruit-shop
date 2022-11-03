package com.basesyntax.strategy.impl;

import com.basesyntax.dao.OperationHandler;
import com.basesyntax.dao.impl.OperationHandlerBalanceImpl;
import com.basesyntax.dao.impl.OperationHandlerPurchaseImpl;
import com.basesyntax.dao.impl.OperationHandlerReturnImpl;
import com.basesyntax.dao.impl.OperationHandlerSupplyImpl;
import com.basesyntax.enums.Operation;
import com.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<String, OperationHandler> strategyMap = new HashMap<>();

    @Override
    public void addStrategyType(String operationType, OperationHandler operationHandler) {
        strategyMap.put(Operation.BALANCE.getOperation(), new OperationHandlerBalanceImpl());
        strategyMap.put(Operation.RETURN.getOperation(), new OperationHandlerReturnImpl());
        strategyMap.put(Operation.SUPPLY.getOperation(), new OperationHandlerSupplyImpl());
        strategyMap.put(Operation.PURCHASE.getOperation(), new OperationHandlerPurchaseImpl());
    }

    @Override
    public OperationHandler getStrategyType(String type) {
        return strategyMap.get(type);
    }
}
