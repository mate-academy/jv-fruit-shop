package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadCsvFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteCsvFileService;
import core.basesyntax.service.implementations.FruitShopServiceImpl;
import core.basesyntax.service.implementations.ParseServiceImpl;
import core.basesyntax.service.implementations.ReadCsvFileServiceImpl;
import core.basesyntax.service.implementations.ReportServiceImpl;
import core.basesyntax.service.implementations.WriteCsvFileServiceImpl;
import core.basesyntax.strategy.DataHandlerStrategy;
import core.basesyntax.strategy.DataHandlerStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceDataHandler;
import core.basesyntax.strategy.handlers.DataHandler;
import core.basesyntax.strategy.handlers.PurchaseDataHandler;
import core.basesyntax.strategy.handlers.ReturnDataHandler;
import core.basesyntax.strategy.handlers.SupplyDataHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/inputDayActivity.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadCsvFileService readCsvFileService = new ReadCsvFileServiceImpl();
        List<String> data = readCsvFileService.readFile(SOURCE_FILE);
        ParseService parseService = new ParseServiceImpl();

        // Build Map [Operation:Handler]
        Map<FruitTransaction.Operation, DataHandler> enumHandlerMap = new HashMap<>();
        DataHandler balance = new BalanceDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.BALANCE, balance);
        DataHandler returns = new ReturnDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.RETURN, returns);
        DataHandler purchase = new PurchaseDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchase);
        DataHandler supply = new SupplyDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.SUPPLY, supply);
        // create strategy
        DataHandlerStrategy dataHandlerStrategy = new DataHandlerStrategyImpl(enumHandlerMap);
        // fill Storage depending on operations and strategy
        FruitShopServiceImpl fruitShopService =
                new FruitShopServiceImpl(dataHandlerStrategy);
        List<FruitTransaction> fruitTransactions = parseService.parseDataToTransaction(data);
        fruitShopService.updateData(fruitTransactions);
        // Build report
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();
        // Write the data to the report file
        WriteCsvFileService writeCsvFileService = new WriteCsvFileServiceImpl();
        writeCsvFileService.writeFile(REPORT_FILE, report);
        if (Files.exists(Path.of(REPORT_FILE))) {
            System.out.println("Database updated and report generated successfully.");
        }
    }
}
