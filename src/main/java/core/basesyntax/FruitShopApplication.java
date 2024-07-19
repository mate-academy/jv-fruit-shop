package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.domain.Fruit;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.operation.*;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<String> readLines = fileService.read("fruits.csv");
        DataConverterService dataConverterService = new DataConverterImpl();
        List<Fruit> convertedFruits = dataConverterService.convertToFruit(readLines);
        Map<Fruit.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Fruit.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Fruit.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy, new FruitDaoImpl());
        shopService.process(convertedFruits);
        ReportService reportService = new ReportServiceImpl();
        String generatedReport = reportService.generateReport();
        fileService.writeToFile(generatedReport, "resultReport.csv");
    }
}
