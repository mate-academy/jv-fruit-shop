package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileDataConvertorService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.BalanceServiceImpl;
import core.basesyntax.service.impl.FileDataConvertorServiceImpl;
import core.basesyntax.service.impl.PurchaseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReturnServiceImpl;
import core.basesyntax.service.impl.SupplyServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final int HEADER_INDEX = 0;
    private static String filePath;
    private static String reportPath;
    private static ReaderService reader;
    private static FileDataConvertorService convertorService;
    private static Storage storage;
    private static Strategy strategy;
    private static ReportService reportService;
    private static WriterService writerService;

    public static void main(String[] args) {
        init();
        List<String> content = reader.readFromFile(filePath);
        content.remove(HEADER_INDEX);
        List<FruitTransaction> fruitTransactions =
                convertorService.convertToFruitTransaction(content);
        fruitTransactions.forEach(x -> strategy.doOperation(x));
        String report = reportService.createReport(storage);
        writerService.write(report, reportPath);
    }

    private static void init() {
        filePath = "src/main/resources/Test.csv";
        reportPath = "src/main/resources/Report.csv";
        reader = new ReaderServiceImpl();
        convertorService = new FileDataConvertorServiceImpl();
        storage = new Storage();

        Map<FruitTransaction.Operation, OperationService> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE,
                new BalanceServiceImpl(storage));
        operationStrategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseServiceImpl(storage));
        operationStrategies.put(FruitTransaction.Operation.RETURN,
                new ReturnServiceImpl(storage));
        operationStrategies.put(FruitTransaction.Operation.SUPPLY,
                new SupplyServiceImpl(storage));

        strategy = new Strategy(operationStrategies);
        reportService = new ReportServiceImpl();
        writerService = new WriteServiceImpl();
    }
}
