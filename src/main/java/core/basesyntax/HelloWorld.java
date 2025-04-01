package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

    public static void main(String[] arg) {

        Map<FruitTransaction.OperationType, OperationStrategy> operationStrategies =
                new HashMap<>();
        operationStrategies.put(FruitTransaction.OperationType.BALANCE,
                new BalanceHandler());
        operationStrategies.put(FruitTransaction.OperationType.SUPPLY, new SupplyHandler());
        operationStrategies.put(FruitTransaction.OperationType.PURCHASE, new PurchaseHandler());
        operationStrategies.put(FruitTransaction.OperationType.RETURN, new ReturnHandler());

    }
}
