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
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_CSV_FILE = "src/main/resources/inputData.csv";
    public static final String OUTPUT_CSV_FILE = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        FruitService fruitService = new FruitServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> fruitTransactions = readerService.readFromFile(INPUT_CSV_FILE);
        List<FruitTransaction> parsedFruitTransactions = parserService.parse(fruitTransactions);

        Map<FruitTransaction.Operation, OperationHandler> mapOfOperations = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler()
        );
        OperationStrategy operationStrategy = new OperationStrategy(mapOfOperations);
        fruitService.writeActionToStorage(parsedFruitTransactions, operationStrategy);

        String createdReport = reportService.createReport();
        writerService.writeToFile(OUTPUT_CSV_FILE, createdReport);

    }
}
