package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public FruitStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        {
            switch (operation) {
                case BALANCE -> {
                    return new BalanceHandlerImpl();
                }
                case SUPPLY -> {
                    return new SupplyHandlerImpl();
                }
                case PURCHASE -> {
                    return new PurchaseHandlerImpl();
                }
                case RETURN -> {
                    return new ReturnHandlerImpl();
                }
                default -> {
                    return null;
                }
            }
        }
    }
}
