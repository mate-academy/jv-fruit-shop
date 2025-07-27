package core.basesyntax;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceHandler;
import core.basesyntax.handler.impl.PurchaseHandler;
import core.basesyntax.handler.impl.ReturnHandler;
import core.basesyntax.handler.impl.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/reportToRead.csv";

        ReaderService reader = new CsvReaderServiceImpl();
        ParserService parser = new ParserServiceImpl();

        List<String> raw = reader.readFromFile(inputPath);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        List<FruitTransaction> transactions = parser.parse(raw);
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        FruitService fruitService = new FruitServiceImpl(strategy);
        fruitService.process(transactions);

        ReportService reporter = new ReportServiceImpl();
        String report = reporter.generateReport();

        String outputPath = "src/main/resources/finalReport.csv";
        WriterService writer = new CsvWriterServiceImpl();
        writer.writeToFile(outputPath, report);
    }
}
