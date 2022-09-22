package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
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
        operationOperationsMap.put(Operation.B, balanceService);
        operationOperationsMap.put(Operation.P, purchaseService);
        operationOperationsMap.put(Operation.S, supplyService);
        operationOperationsMap.put(Operation.R, returnService);

        ReaderService readerService = new ReaderServiceImpl();
        ShopService shopService = new ShopServiceImpl(new OperationsStrategyImpl(operationOperationsMap));
        shopService.transaction( readerService.readFromString("b,banana,20"+ System.lineSeparator() +
                "b,apple,100" + System.lineSeparator() +
                "s,banana,100" + System.lineSeparator() +
                "p,banana,13" + System.lineSeparator() +
                "r,apple,10"));
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile().forEach(System.out::println);
    }

}

