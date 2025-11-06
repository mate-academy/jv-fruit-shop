package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.provider.StrategyProvider;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String READ_FILE_NAME = "fruits.txt";
    private static final String WRITE_FILE_NAME = "fruits_report.txt";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl(
                new CsvFileReader(),
                new CsvFileWriter()
        );
        DataParserService dataParser = new DataParserServiceImpl(
                new CsvDataParser()
        );
        Map<Operation, OperationStrategy> strategyMap = new HashMap<>();
        strategyMap.put(Operation.RETURN, new ReturnOperation());
        strategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        strategyMap.put(Operation.BALANCE, new BalanceOperation());
        strategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        StrategyProvider strategyProvider = new StrategyProvider(strategyMap);
        ReportService reportService = new ReportServiceImpl(
                new CalculateAvailableFruits(strategyProvider)
        );

        List<String> fileData = fileService.read(
                generateFilePath(READ_FILE_NAME)
        );
        List<FruitTransaction> parsedData = dataParser.parse(fileData);
        String reportData = reportService.createReport(parsedData);
        fileService.write(
                generateFilePath(WRITE_FILE_NAME),
                reportData
        );
    }

    private static String generateFilePath(String fileName) {
        return FILE_PATH + fileName;
    }
}
