package core.basesyntax.service.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.StorageLoader;
import core.basesyntax.service.handlers.BalanceHandler;
import core.basesyntax.service.handlers.PurchaseHandler;
import core.basesyntax.service.handlers.ReturnHandler;
import core.basesyntax.service.handlers.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageLoaderImpl implements StorageLoader {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;

    @Override
    public void load(List<String[]> fruitInfo) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        OperationHandler handler;
        DataValidator validator = new DataValidatorImpl();

        for (String[] s : fruitInfo) {
            validator.validate(s);
            String operationCode = s[OPERATION_INDEX].trim();
            FruitTransaction.Operation operation = FruitTransaction.findOperation(operationCode);

            FruitTransaction transaction = new FruitTransaction(
                    operation, s[FRUIT_INDEX], Integer.parseInt(s[AMOUNT_INDEX]));
            handler = strategy.get(transaction.getOperation());
            handler.handler(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
