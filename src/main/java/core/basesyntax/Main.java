package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operations.BalanceService;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.Operations;
import core.basesyntax.service.operations.OperationsStrategyImpl;
import core.basesyntax.service.operations.PurchaseService;
import core.basesyntax.service.operations.ReturnService;
import core.basesyntax.service.operations.SupplyService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BalanceService balanceService = new BalanceService();
        PurchaseService purchaseService = new PurchaseService();
        SupplyService supplyService = new SupplyService();
        ReturnService returnService = new ReturnService();

        Map<Operation, Operations> operationOperationsMap = new HashMap<>();
        operationOperationsMap.put(Operation.BALANCE, balanceService);
        operationOperationsMap.put(Operation.PURCHASE, purchaseService);
        operationOperationsMap.put(Operation.SUPPLY, supplyService);
        operationOperationsMap.put(Operation.RETURN, returnService);

        ReaderService readerService = new ReaderServiceImpl();
        ShopService shopService = new ShopServiceImpl(new OperationsStrategyImpl(operationOperationsMap));
        shopService.transaction( readerService.readFromFile("type,fruit,quantity" +
                "b,banana,20" +
                "b,apple,100" +
                "s,banana,100" +
                "p,banana,13" +
                "r,apple,10"));

    }
}

