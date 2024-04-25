package core.basesyntax;

import core.basesyntax.operation.Transaction;
import core.basesyntax.service.BalanceQuantityCounter;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.PurchaseQuantityCounter;
import core.basesyntax.service.QuantityCounter;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.ReturnQuantityCounter;
import core.basesyntax.service.SupplyQuantityCounter;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.TransactionProcessorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String STORAGE_FILE_PATH = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static Map<Transaction.Operation, QuantityCounter> quantityCounterMap;

    public static void main(String[] args) {
        quantityCounterMap = Map.of(Transaction.Operation.BALANCE, new BalanceQuantityCounter(),
                Transaction.Operation.SUPPLY, new SupplyQuantityCounter(),
                Transaction.Operation.PURCHASE, new PurchaseQuantityCounter(),
                Transaction.Operation.RETURN, new ReturnQuantityCounter());
        FileService fileService = new FileServiceImpl();
        List<String> fileInfo = fileService.readFile(STORAGE_FILE_PATH);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<Transaction> transactions = transactionParser.parse(fileInfo);
        TransactionProcessor processor = new TransactionProcessorImpl();
        Map<String, Integer> endOfDayQuantities = processor.process(transactions);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(endOfDayQuantities);
        fileService.writeToFile(report, REPORT_FILE_PATH);
    }

    public static Map<Transaction.Operation, QuantityCounter> getOperationMap() {
        return quantityCounterMap;
    }
}
