package core.basesyntax;

import core.basesyntax.dao.reader.ReaderCsv;
import core.basesyntax.dao.reader.ReaderCsvImpl;
import core.basesyntax.dao.writer.WriterCsv;
import core.basesyntax.dao.writer.WriterCsvImpl;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.parser.ParserCsv;
import core.basesyntax.service.parser.ParserCsvImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.storage.StorageService;
import core.basesyntax.service.storage.StorageServiceImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path FROM_FILE = Path.of("src/main/resources/database.csv");
    private static final Path TO_FILE = Path.of("src/main/resources/report.csv");

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        ReaderCsv csvReader = new ReaderCsvImpl();
        ParserCsv csvParser = new ParserCsvImpl();
        FruitStorage storage = new FruitStorageImpl();
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        StorageService storageService = new StorageServiceImpl(operationStrategy);
        ReportService reportGenerator = new ReportServiceImpl(storage);
        WriterCsv csvWriter = new WriterCsvImpl();

        List<String> lines = csvReader.read(FROM_FILE);
        List<FruitTransaction> transactions = csvParser.parseTransactions(lines);
        storageService.transfer(transactions);
        List<String> report = reportGenerator.createReport();
        csvWriter.writeToFile(TO_FILE, report);
    }
}
