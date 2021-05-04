package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.handler.BalanceHandler;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.PurchaseHandler;
import core.basesyntax.service.handler.ReturnHandler;
import core.basesyntax.service.handler.SupplyHandler;
import core.basesyntax.service.file.FileService;
import core.basesyntax.service.file.FileServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/inputFile";
    private static final String OUTPUT_FILE = "src/main/DailyReport";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getOperation(), new BalanceHandler());
        operationHandlerMap.put(OperationType.SUPPLY.getOperation(), new SupplyHandler());
        operationHandlerMap.put(OperationType.PURCHASE.getOperation(), new PurchaseHandler());
        operationHandlerMap.put(OperationType.RETURN.getOperation(), new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(fruitShopDao, operationStrategy);
        FileService readerService = new FileServiceImpl();
        FileService writerService = new FileServiceImpl();
        List<String> data = readerService.readFile(INPUT_FILE);
        fruitShopService.saveData(data);
        String report = fruitShopService.getReport();
        writerService.writeToFile(report, OUTPUT_FILE);

    }
}
