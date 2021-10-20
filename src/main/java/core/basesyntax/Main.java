package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaocsv;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.FileValidator;
import core.basesyntax.service.FruitParser;
import core.basesyntax.service.FruitParserImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.FruitStrategy;
import core.basesyntax.service.FruitStrategyImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.ReportWriterImpl;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
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
        FruitDao fruitDao = new FruitDaocsv();
        FruitStrategy fruitStrategy = new FruitStrategyImpl(fruitOperationMap);
        FruitParser fruitParser = new FruitParserImpl(fruitStrategy);
        DataValidator dataValidator = new FileValidator();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportWriter reportWriter = new ReportWriterImpl();
        FruitService fruitService = new FruitServiceImpl(fruitDao, fruitParser,
                dataValidator, reportCreator, reportWriter);
        fruitService.createReport("resources\\fruitLogs.csv", "resources\\report.csv");

    }

}
