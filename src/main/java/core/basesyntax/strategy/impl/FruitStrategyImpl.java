package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public FruitStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation is null");
        }
        {
            switch (operation) {
                case BALANCE -> {
                    return new BalanceHandlerImpl(new ListServiceImpl());
                }
                case SUPPLY -> {
                    return new SupplyHandlerImpl(new ListServiceImpl());
                }
                case PURCHASE -> {
                    return new PurchaseHandlerImpl(new ListServiceImpl());
                }
                case RETURN -> {
                    return new ReturnHandlerImpl(new ListServiceImpl());
                }
                default -> {
                    throw new RuntimeException("Invalid operation");
                }
            }
        }
    }
}
