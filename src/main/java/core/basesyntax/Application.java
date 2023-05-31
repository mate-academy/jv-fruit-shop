package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap
                = Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler());
        ReaderService reader = new ReaderServiceImpl();
        ParserService parser = new ParserServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(handlerMap);
        FruitService fruitShopService = new FruitServiceImpl(strategy);
        ReportService reportMakerService = new ReportServiceImpl();
        WriterService writer = new WriterServiceImpl();
        List<String> stringsFromFile = reader.readFromFile(PATH_TO_INPUT_FILE);
        List<FruitTransaction> transactions = parser.parse(stringsFromFile);
        fruitShopService.process(transactions);
        String report = reportMakerService.createReport();
        writer.writeToFile(PATH_TO_REPORT_FILE, report);
    }
}
