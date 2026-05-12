package core.basesyntax;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.inout.CsvWriter;
import core.basesyntax.inout.LineReader;
import core.basesyntax.inout.LineReaderFactory;
import core.basesyntax.inout.ReaderType;
import core.basesyntax.inout.ReportWriter;
import core.basesyntax.parser.DataConverter;
import core.basesyntax.parser.DataConverterImpl;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.Operation;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.ShopTransaction;
import core.basesyntax.transaction.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String DEFAULT_INPUT_FILE = "data/data.csv";
    private static final String DEFAULT_OUTPUT_FILE = "finalReport.csv";

    public static void main(String[] args) {
        String filePath = args.length > 0
                ? args[0]
                : System.getProperty("config.file", DEFAULT_INPUT_FILE);

        // 1. Initialize dependencies
        Storage storage = new ShopStorage();
        Transaction transaction = new ShopTransaction(storage);

        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy, transaction);
        DataConverter converter = new DataConverterImpl();
        LineReader reader = LineReaderFactory.create(ReaderType.CSV);

        // 2. Read and convert data
        List<FruitTransaction> transactions;
        try (Stream<String> lines = reader.readLines(filePath)) {
            transactions = converter.convertToTransaction(lines).collect(Collectors.toList());
        }

        // 3. Process transactions
        shopService.process(transactions);

        // 4. Generate and write report
        ReportGenerator generator = new ReportGeneratorImpl(storage);
        ReportWriter writer = new CsvWriter();
        writer.write(DEFAULT_OUTPUT_FILE, generator.getReport());
    }
}
