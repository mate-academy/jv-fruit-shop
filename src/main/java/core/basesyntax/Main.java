package core.basesyntax;

import core.basesyntax.dao.BalanceDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceOperationHandler;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.ReturnOperationHandler;
import core.basesyntax.strategy.operations.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String BALANCE_FILE_NAME = "src/main/resources/database.csv";
    private static final String PIVOT_FILE_NAME = "src/main/resources/pivot.csv";

    public static void main(String[] args) {

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        Storage storage = new Storage(new BalanceDaoImpl().getBalanceFromFile(BALANCE_FILE_NAME));
        BalanceService balanceService
                = new BalanceServiceImpl(storage.getTransactions(), operationStrategy);

        balanceService.exportPivotToFile(PIVOT_FILE_NAME);
    }
}
