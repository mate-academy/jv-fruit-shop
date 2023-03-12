package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.impl.BalanceTransactionHandler;
import core.basesyntax.strategy.impl.PurchaseTransactionHandler;
import core.basesyntax.strategy.impl.ReturnTransactionHandler;
import core.basesyntax.strategy.impl.SupplyTransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String pathDataFile = "src/main/java/resources/data.csv";
    private static final String pathReportFile = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readData = fileReaderService.readFile(pathDataFile);

        TransactionParserService parserService = new TransactionParserServiceImpl();
        ShopService shopService = new ShopServiceImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactions = parserService.parseTransaction(readData);
        shopService.processData(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeFile(reportService.createReport(), pathReportFile);
        System.out.println(reportService.createReport());
    }
}
