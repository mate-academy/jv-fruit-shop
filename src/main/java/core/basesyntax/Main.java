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
import core.basesyntax.strategy.handler.BalanceDataHandler;
import core.basesyntax.strategy.handler.DataHandler;
import core.basesyntax.strategy.handler.PurchaseDataHandler;
import core.basesyntax.strategy.handler.ReturnDataHandler;
import core.basesyntax.strategy.handler.SupplyDataHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/inputDayActivity.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final ParseService parseService = new ParseServiceImpl();
    private static final ReadCsvFileService readCsvFileService = new ReadCsvFileServiceImpl();
    private static final WriteCsvFileService writeCsvFileService = new WriteCsvFileServiceImpl();
    private static final Map<FruitTransaction.Operation, DataHandler> enumHandlerMap =
            new HashMap<>();
    private static final DataHandlerStrategy dataHandlerStrategy
            = new DataHandlerStrategyImpl(enumHandlerMap);
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        List<String> data = readCsvFileService.readFile(SOURCE_FILE);
        List<FruitTransaction> fruitTransactions = parseService.parseDataToTransaction(data);
        // Build Map [Operation:Handler]
        DataHandler balance = new BalanceDataHandler();
        DataHandler supply = new SupplyDataHandler();
        DataHandler purchase = new PurchaseDataHandler();
        DataHandler returns = new ReturnDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.BALANCE, balance);
        enumHandlerMap.put(FruitTransaction.Operation.RETURN, returns);
        enumHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchase);
        enumHandlerMap.put(FruitTransaction.Operation.SUPPLY, supply);
        // fill Storage depending on operations and strategy
        FruitShopServiceImpl fruitShopService =
                new FruitShopServiceImpl(fruitTransactions, dataHandlerStrategy);
        fruitShopService.updateData();
        // Build report
        List<String> report = reportService.generateReport();
        // Write the data to the report file
        writeCsvFileService.writeFile(REPORT_FILE, report);
        if (Files.isReadable(Path.of(REPORT_FILE))) {
            System.out.println("Database updated and report generated successfully.");
        }
    }
}
