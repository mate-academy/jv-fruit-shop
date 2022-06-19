package core.basesyntax;

import core.basesyntax.Dao.BalanceDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.BalanceServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operations.*;

import java.util.HashMap;
import java.util.Map;

public class FruitShopBalancer {
    private static final String BALANCE_FILE_NAME = "database.csv";
    private static final String PIVOT_FILE_NAME = "pivot.csv";

    public static void main(String[] args) {

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        Storage.transactions = new BalanceDaoImpl().getBalanceFromFile(BALANCE_FILE_NAME);
        BalanceService balanceService = new BalanceServiceImpl(Storage.transactions, operationStrategy);

        balanceService.exportPivotToFile(PIVOT_FILE_NAME);
    }


}
