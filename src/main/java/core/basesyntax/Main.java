package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.OperationType;
import core.basesyntax.service.operation.impl.BalanceOperationImpl;
import core.basesyntax.service.operation.impl.PurchaseOperationImpl;
import core.basesyntax.service.operation.impl.ReturnOperationImpl;
import core.basesyntax.service.operation.impl.SupplyOperationImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<FruitTransaction.Operation, OperationType> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationImpl());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationImpl());
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationImpl());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationImpl());

        ShopService service = new ShopServiceImpl(operationHandlers,
                "src/main/resources/inputData.csv");
        service.reportMaker();
    }
}
