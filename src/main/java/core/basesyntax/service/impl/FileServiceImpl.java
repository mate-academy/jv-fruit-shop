package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataTransactionParser;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.impl.BalanceOperationImpl;
import core.basesyntax.strategy.operation.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.operation.impl.ReturnOperationImpl;
import core.basesyntax.strategy.operation.impl.SupplyOperationImpl;
import java.util.HashMap;
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

    public Map<String, OperationHandler> prepareAndGetOperationData() {
        Map<String, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationImpl());
        return operationServiceMap;
    }

    public String readData() {
        ReaderService readerService = new FileReaderServiceImpl();
        return readerService.read();
    }

    public String processFruitsData(Map<String, OperationHandler> operationServiceMap,
                                    String data) {
        if (operationServiceMap == null || data == null || data.isBlank()) {
            throw new IllegalArgumentException("Input data is not correct");
        }
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        DataTransactionParser dataTransactionParser =
                new DataTransactionParserImpl(operationStrategy);
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
