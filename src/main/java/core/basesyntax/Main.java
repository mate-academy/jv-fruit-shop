package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoCSVImpl;
import core.basesyntax.service.*;
import core.basesyntax.service.operation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> fruitOperationMap = new HashMap<>();
        fruitOperationMap.put("b", new BalanceHandler());
        fruitOperationMap.put("s", new SupplyHandler());
        fruitOperationMap.put("p", new PurchaseHandler());
        fruitOperationMap.put("r", new ReturnHandler());
        FruitDao fruitDao = new FruitDaoCSVImpl("resources\\fruitLogs.csv");
        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruitOperationMap);
        FruitParser fruitParser = new FruitParserImpl(fruitDao, fruitStrategy);
        DataValidator dataValidator = new CSVFileValidator();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportWriter reportWriter = new ReportWriterImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao, fruitParser,
                dataValidator, reportCreator, reportWriter);
        fruitService.createReport("resources\\fruitLogs.csv", "resources\\report.csv");

    }

}
