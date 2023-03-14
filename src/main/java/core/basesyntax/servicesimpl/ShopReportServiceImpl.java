package core.basesyntax.servicesimpl;

import core.basesyntax.services.CsvFileReaderService;
import core.basesyntax.services.CsvFileWriterService;
import core.basesyntax.services.DataParcerService;
import core.basesyntax.services.DataProcessingService;
import core.basesyntax.services.ShopReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ShopReportServiceImpl implements ShopReportService {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String VALUE_SEPARATOR = ",";
    public static final String TITLE_ROW = "fruit,quantity";
    private OperationStrategy operationStrategy;

    public ShopReportServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void createReport(Path inputDataPath, Path reportDataPath) {
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String> inputData = readerService.readFromFile(inputDataPath);

        DataParcerService dataParcerService = new DataParcerServiceImpl();
        List<String[]> parcedData = dataParcerService.parceDataFromCsv(inputData);

        DataProcessingService dataProcessingService =
                new DataProcessingServiceImpl(operationStrategy);
        Map<String, Integer> processedData = dataProcessingService.processData(parcedData);

        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToCsvFile(generateReport(processedData), reportDataPath);
    }

    private byte[] generateReport(Map<String, Integer> resultMap) {
        StringBuilder sb = new StringBuilder().append(TITLE_ROW).append(LINE_SEPARATOR);
        resultMap.forEach((key, value) -> sb.append(key)
                .append(VALUE_SEPARATOR)
                .append(value)
                .append(LINE_SEPARATOR));
        return sb.toString().getBytes();
    }
}
