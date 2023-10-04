package core.basesyntax;

import core.basesyntax.enumeration.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.parser.ReportService;
import core.basesyntax.service.parser.impl.ParserServiceImpl;
import core.basesyntax.service.parser.impl.ReportServiceImpl;
import core.basesyntax.strategy.FruitHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceFruitHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseFruitHandlerImpl;
import core.basesyntax.strategy.impl.ReturnFruitHandlerImpl;
import core.basesyntax.strategy.impl.SupplyFruitHandlerImpl;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String pathFromFile = "src/main/resources/input_data";
    private static final String pathToFile = "src/main/resources/report";

    public static void main(String[] args) {
        FruitHandlerStrategy fruitHandlerStrategy = new FruitHandlerStrategy(new HashMap<>() {
            {
                put(Operation.BALANCE, new BalanceFruitHandlerImpl());
                put(Operation.SUPPLY, new SupplyFruitHandlerImpl());
                put(Operation.PURCHASE, new PurchaseFruitHandlerImpl());
                put(Operation.RETURN, new ReturnFruitHandlerImpl());
            }
        });
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(pathFromFile);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseData(dataFromFile);
        FruitService activityService = new FruitServiceImpl();
        activityService.processAllTransations(fruitTransactions, fruitHandlerStrategy);
        ReportService parserMapToString = new ReportServiceImpl();
        String reportFromFruitStorage = parserMapToString.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReportToCsvFile(reportFromFruitStorage, pathToFile);
    }
}
