package core.basesyntax;

import db.StorageService;
import db.StorageServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import report.ReportFormatter;
import report.ReportGenerator;
import report.impl.CsvReportFormatter;
import report.impl.ReportGenerationImpl;
import service.ReaderService;
import service.ShopService;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceImpl;
import strategy.PurchaseImpl;
import strategy.ReturnImpl;
import strategy.SupplyImpl;

public class HelloWorld {
    private static final String INPUT_FILE_PATH = "reportToRead.csv";
    private static final String OUTPUT_FILE_PATH = "fileReport.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<FruitTransaction> transactions = readerService.readFromFile(INPUT_FILE_PATH);

        Map<Operation, strategy.Operation> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseImpl());
        operationHandlers.put(Operation.SUPPLY, new SupplyImpl());
        operationHandlers.put(Operation.RETURN, new ReturnImpl());

        StorageService storageService = new StorageServiceImpl();
        ShopService shopService = new ShopServiceImpl(storageService, operationHandlers);
        Map<String, Integer> storage = shopService.processTransactions(transactions);

        ReportFormatter formatter = new CsvReportFormatter();
        ReportGenerator generator = new ReportGenerationImpl();
        WriterService writerService = new WriterServiceImpl();
        String report = generator.generateReport(storage, formatter);
        writerService.writeReport(report, OUTPUT_FILE_PATH);
    }
}
