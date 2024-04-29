package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.strategy.BalanceStrategyHandlerImpl;
import core.basesyntax.strategy.PurchaseStrategyHandlerImpl;
import core.basesyntax.strategy.ReturnStrategyHandlerImpl;
import core.basesyntax.strategy.StrategyHandler;
import core.basesyntax.strategy.SupplyStrategyHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        Map<String, StrategyHandler> strategyHandlerMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl(new StrategyServiceImpl(strategyHandlerMap));
        strategyHandlerMap.put("b", new BalanceStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put("s", new SupplyStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put("p", new PurchaseStrategyHandlerImpl(fruitDao));
        strategyHandlerMap.put("r", new ReturnStrategyHandlerImpl(fruitDao));
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String filePath =
                "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/InputFile.csv";
        List<String> readFromFile = fileReaderService.readFile(filePath);
        ReportService reportService = new ReportServiceImpl(fruitDao);
        reportService.calculateDataForReport(readFromFile);
        FileWriterService fileWriterService = new FileWriteServiceImpl();
        fileWriterService.writeReport(fruitDao.getFruitList());
    }
}
