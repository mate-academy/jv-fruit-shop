package core.basesyntax.app;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitParser fruitParser = new FruitParser();
        FileService fileService = new FileServiceImpl(fruitParser);
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.B, new BalanceHandler());
        handlers.put(Operation.S, new AddOperationHandler());
        handlers.put(Operation.R, new AddOperationHandler());
        handlers.put(Operation.P, new PurchaseHandler());
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        List<FruitTransaction> transactions = fileService.loadFromFile("input.csv");
        ShopService shopService = new ShopServiceImpl(strategy);
        Map<String, Integer> finalReportData = shopService.process(transactions);
        fileService.saveToFile(finalReportData, "report.csv");
        System.out.println("pierdole te ai");
    }
}
