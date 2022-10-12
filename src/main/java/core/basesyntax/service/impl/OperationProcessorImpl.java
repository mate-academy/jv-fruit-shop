package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessing;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;

public class OperationProcessorImpl implements OperationProcessor {
    private static FruitDao fruitDao = new FruitDaoImpl();
    private OperationStrategy operationStrategy;
    public static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    static {
        operationHandlerMap = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
    }

    public OperationProcessorImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
        handler.handle(fruitTransaction);
    }
}
