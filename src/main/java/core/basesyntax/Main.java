package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.services.CsvFileReaderService;
import core.basesyntax.services.CsvFileWriterService;
import core.basesyntax.services.DataParcerService;
import core.basesyntax.services.DataProcessingService;
import core.basesyntax.services.ShopReportService;
import core.basesyntax.services.impl.CsvFileReaderServiceImpl;
import core.basesyntax.services.impl.CsvFileWriterServiceImpl;
import core.basesyntax.services.impl.DataParcerServiceImpl;
import core.basesyntax.services.impl.DataProcessingServiceImpl;
import core.basesyntax.services.impl.ShopReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperarionHandlerPurchase;
import core.basesyntax.strategy.impl.OperationHandlerBalance;
import core.basesyntax.strategy.impl.OperationHandlerReturn;
import core.basesyntax.strategy.impl.OperationHandlersSupply;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_DATA_PATH = "src/main/resources/FruitShopInputData.csv";
    private static final String REPORT_DATA_PATH = "src/main/resources/FruitShopOutputData.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getCode(),new OperationHandlerBalance());
        operationHandlerMap.put(OperationType.SUPPLY.getCode(),new OperationHandlersSupply());
        operationHandlerMap.put(OperationType.RETURN.getCode(),new OperationHandlerReturn());
        operationHandlerMap.put(OperationType.PURCHASE.getCode(),new OperarionHandlerPurchase());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> inputData = readerService.readFromFile(Path.of(INPUT_DATA_PATH));

        DataParcerService dataParcerService = new DataParcerServiceImpl();
        List<String[]> parcedData = dataParcerService.parceDataFromCsv(inputData);

        DataProcessingService dataProcessingService =
                new DataProcessingServiceImpl(operationStrategy);
        Map<String, Integer> processedData = dataProcessingService.processData(parcedData);

        ShopReportService reportService = new ShopReportServiceImpl();
        byte[] report = reportService.generateReport(processedData);

        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToCsvFile(report, Path.of(REPORT_DATA_PATH));
    }
}
