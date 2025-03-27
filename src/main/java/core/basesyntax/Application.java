package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import report.ReportFormatter;
import report.ReportGenerator;
import report.impl.CsvReportFormatter;
import report.impl.ReportGenerationImpl;
import service.ParseService;
import service.ReaderService;
import service.ShopService;
import service.WriterService;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceImpl;
import strategy.PurchaseImpl;
import strategy.ReturnImpl;
import strategy.SupplyImpl;

public class Application {

    public void run(String inputFilePath, String outputFilePath) {
        ParseService parseService = new ParseServiceImpl();
        ReaderService readerService = new ReaderServiceImpl(parseService);
        List<FruitTransaction> transactions = readerService.readFromFile(inputFilePath);

        Map<FruitTransaction.Operation, strategy.Operation> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseImpl());
        operationHandlers.put(Operation.SUPPLY, new SupplyImpl());
        operationHandlers.put(Operation.RETURN, new ReturnImpl());

        ShopService shopService = new ShopServiceImpl(operationHandlers);
        Map<String, Integer> storage = shopService.processTransactions(transactions);

        ReportFormatter formatter = new CsvReportFormatter();
        ReportGenerator generator = new ReportGenerationImpl();
        WriterService writerService = new WriterServiceImpl();
        String report = generator.generateReport();
        writerService.writeReport(report, outputFilePath);
    }
}
