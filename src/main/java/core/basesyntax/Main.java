package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.implementations.*;
import core.basesyntax.strategy.DataHandlerStrategy;
import core.basesyntax.strategy.DataHandlerStrategyImpl;
import core.basesyntax.strategy.handler.DataHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE = "src/main/resources/inputDayActivity.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final ParseService parseService = new ParseServiceImpl();
    private static final ReadCsvFileService readCsvFileService = new ReadCsvFileServiceImpl();
    private static final WriteCsvFileService writeCsvFileService = new WriteCsvFileServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final MapBuilderOperationServiceImpl springImitator =
            new MapBuilderOperationServiceImpl();
    private static Map<FruitTransaction.Operation, DataHandler> enumHandlerMap;
    private static DataHandlerStrategy dataHandlerStrategy;

    public static void main(String[] args) {
        List<String> data = readCsvFileService.readFile(SOURCE_FILE);
        List<FruitTransaction> fruitTransactions = parseService.parseDataToTransaction(data);
        // Build Map [Operation:Handler]
        enumHandlerMap = springImitator.initializeMap();
        dataHandlerStrategy = new DataHandlerStrategyImpl(enumHandlerMap);
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
