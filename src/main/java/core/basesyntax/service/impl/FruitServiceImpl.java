package core.basesyntax.service.impl;

import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.operation.OperationHandler;

import java.util.Map;

public class FileServiceImpl implements FileService {
    private static String fromFile = "src/main/resources/input.csv";
    private static String toFile = "src/main/resources/output.csv";

    public static String getFromFile() {
        return fromFile;
    }

    public static String getToFile() {
        return toFile;
    }

    public String readData() {
        ReaderService readerService = new FileReaderServiceImpl();
        return readerService.read();
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

    public void createResultFile(String report) {
        if (report == null || report.isBlank()) {
            throw new IllegalArgumentException("Input data is not correct");
        }
        WriterService writerService = new FileWriterServiceImpl();
        writerService.write(report);
    }
}
