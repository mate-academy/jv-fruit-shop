package core.basesyntax.service.impl;

import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    public String readData(String filePath) {
        ReaderService readerService = new FileReaderServiceImpl();
        return readerService.read(filePath);
    }

    public String processFruitsData(Map<String, OperationHandler> operationServiceMap,
                                    String data, DataTransactionParser dataTransactionParser) {
        if (operationServiceMap == null || data == null || data.isBlank()) {
            throw new IllegalArgumentException("Input data is not correct");
        }
        Map<String, Integer> parseDataMap = dataTransactionParser.parseDataTransaction(data);
        ReportGeneratorService generatorService = new ReportGeneratorServiceImpl();
        return generatorService.generateReport(parseDataMap);
    }

    public void createResultFile(String report, String filePath) {
        if (report == null || report.isBlank()) {
            throw new IllegalArgumentException("Input data is not correct");
        }
        WriterService writerService = new FileWriterServiceImpl();
        writerService.write(report, filePath);
    }
}
