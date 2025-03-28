package core.basesyntax;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import report.ReportGenerator;
import report.impl.ReportGeneratorImpl;
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
        Storage.storage.clear();

        ParseServiceImpl parseService = new ParseServiceImpl();
        ReaderService readerService = new ReaderServiceImpl(parseService);

        Map<FruitTransaction.Operation, strategy.Operation>
                operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceImpl());
        operationHandlers.put(Operation.PURCHASE, new PurchaseImpl());
        operationHandlers.put(Operation.SUPPLY, new SupplyImpl());
        operationHandlers.put(Operation.RETURN, new ReturnImpl());

        List<FruitTransaction> transactions = readerService.readFromFile(inputFilePath);
        ShopService shopService = new ShopServiceImpl(operationHandlers);
        shopService.processTransactions(transactions);

        ReportGenerator generator = new ReportGeneratorImpl();
        WriterService writerService = new WriterServiceImpl();
        String report = generator.generateReport();
        writerService.writeReport(report, outputFilePath);
    }
}
