package core.basesyntax;

import core.basesyntax.enums.DataFormatTypes;
import core.basesyntax.enums.InputDataTypes;
import core.basesyntax.enums.OutputDataTypes;
import core.basesyntax.enums.UpdateOperations;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportingService;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.impl.CsvFormatDataProcessingServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ScreenWriterServiceImpl;
import core.basesyntax.service.impl.StorageBalanceServiceImpl;
import core.basesyntax.service.impl.StoragePurchaseServiceImpl;
import core.basesyntax.service.impl.StorageReturnServiceImpl;
import core.basesyntax.service.impl.StorageSupplyServiceImpl;
import core.basesyntax.strategy.ServiceStrategy;
import core.basesyntax.strategy.Strategy;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final InputDataTypes SOURCE_TYPE = InputDataTypes.FILE;
    private static final OutputDataTypes RECEIVER_TYPE = OutputDataTypes.FILE;
    private static final DataFormatTypes CSV_FORMAT_TYPE = DataFormatTypes.CSV;
    private static final String SOURCE_LOCATION = "src/main/resources/data/20221025_0601_ma.csv";
    private static final String FILE_REPORT_EXTENSION = ".csv";
    private static final String REPORTS_DIRECTORY = "src/main/resources/reports";
    private static final String REPORT_HEADER = "fruit,amount";

    public static void main(String[] args) {
        // 1. read data
        Strategy<InputDataTypes, DataReaderService>
                readerStrategy = new ServiceStrategy<>(getReaderStrategyMap());
        DataReaderService readerService = readerStrategy.getService(SOURCE_TYPE)
                .orElseThrow(() -> new RuntimeException("Unsupported reader service type"));
        List<String> inputData = readerService.readData(SOURCE_LOCATION);
        // 2. processing data
        Strategy<DataFormatTypes, DataProcessingService>
                processingStrategy = new ServiceStrategy<>(getProcessingFormatMap());
        DataProcessingService
                processingService = processingStrategy.getService(CSV_FORMAT_TYPE)
                        .orElseThrow(() -> new RuntimeException("Unsupported data format type"));
        processingService.processingData(inputData);
        // 3. build report
        Strategy<DataFormatTypes, ReportingService>
                reportStrategy = new ServiceStrategy<>(getReportingStrategyMap());
        ReportingService reportingService = reportStrategy.getService(CSV_FORMAT_TYPE)
                .orElseThrow(() -> new RuntimeException("Unsupported reporting format type"));
        List<String> report = reportingService.generateReport();
        // 4. write data
        Strategy<OutputDataTypes, DataWriterService>
                writerStrategy = new ServiceStrategy<>(getWriterStrategyMap());
        DataWriterService writerService = writerStrategy.getService(RECEIVER_TYPE)
                .orElseThrow(() -> new RuntimeException("Unsupported writing service type"));
        writerService.writeData(report);
    }

    private static Map<DataFormatTypes, ReportingService> getReportingStrategyMap() {
        return Map.of(
                DataFormatTypes.CSV, new CsvReportServiceImpl(REPORT_HEADER)
        );
    }

    private static Map<DataFormatTypes, DataProcessingService> getProcessingFormatMap() {
        return Map.of(
                DataFormatTypes.CSV, new CsvFormatDataProcessingServiceImpl(
                        getConvertedUpdateOperationStrategyMap(getUpdateOperationStrategyMap()))
        );
    }

    private static Map<InputDataTypes, DataReaderService> getReaderStrategyMap() {
        return Map.of(
                InputDataTypes.FILE, new FileReaderServiceImpl()
        );
    }

    private static Map<OutputDataTypes, DataWriterService> getWriterStrategyMap() {
        return Map.of(
                OutputDataTypes.FILE, new FileWriterServiceImpl(getReportName()),
                OutputDataTypes.SCREEN, new ScreenWriterServiceImpl()
        );
    }

    private static String getReportName() {
        return REPORTS_DIRECTORY + File.separator + LocalDate.now() + FILE_REPORT_EXTENSION;
    }

    private static Map<String, StorageUpdateService> getConvertedUpdateOperationStrategyMap(
            Map<UpdateOperations, StorageUpdateService> strategyMap) {
        return strategyMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getOperation(), Map.Entry::getValue));

    }

    private static Map<UpdateOperations, StorageUpdateService> getUpdateOperationStrategyMap() {
        return Map.of(
                UpdateOperations.BALANCE, new StorageBalanceServiceImpl(),
                UpdateOperations.SUPPLY, new StorageSupplyServiceImpl(),
                UpdateOperations.PURCHASE, new StoragePurchaseServiceImpl(),
                UpdateOperations.RETURN, new StorageReturnServiceImpl()
        );
    }
}
