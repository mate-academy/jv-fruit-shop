package core.basesyntax;

import core.basesyntax.fileserve.FileServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.process.FruitReportMakerImpl;
import core.basesyntax.process.FruitTransactionServiceImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "C:/Study/InputData.txt";
    private static final String OUTPUT_PATH = "C:/Study/Report.txt";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(new FileServiceImpl(),
                new FruitTransactionServiceImpl(operationStrategy),
                new FruitReportMakerImpl());
        System.out.println(fruitShopService.serviceFruitsShop(INPUT_PATH, OUTPUT_PATH));
    }
}
