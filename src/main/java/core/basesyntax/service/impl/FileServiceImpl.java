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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void doTransaction() {
        Map<String, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE.getOperation(),
                new BalanceOperationImpl());
        operationServiceMap.put(Operation.SUPPLY.getOperation(),
                new SupplyOperationImpl());
        operationServiceMap.put(Operation.PURCHASE.getOperation(),
                new PurchaseOperationImpl());
        operationServiceMap.put(Operation.RETURN.getOperation(),
                new ReturnOperationImpl());
        ReaderService readerService;
        String readData;
        readerService = new FileReaderServiceImpl();
        readData = readerService.read();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        DataTransactionParser dataTransactionParser =
                new DataTransactionParserImpl(operationStrategy);
        Map<String, Integer> parseDataMap = dataTransactionParser.parseDataTransaction(readData);
        ReportGeneratorService generatorService = new ReportGeneratorServiceImpl();
        String report = generatorService.generateReport(parseDataMap);
        WriterService writerService;
        try {
            writerService = new FileWriterServiceImpl(
                    new BufferedWriter(new FileWriter(toFile)));
            writerService.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file: ", e);
        }
    }
}
