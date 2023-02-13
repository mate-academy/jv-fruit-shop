package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.AmountCalculator;
import core.basesyntax.service.AmountCalculatorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.data.CsvOperationParser;
import core.basesyntax.service.data.DataParser;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReaderServiceImpl;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.WriterServiceImpl;
import core.basesyntax.service.operation.DecreaseOperationHandler;
import core.basesyntax.service.operation.IncreaseOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/input.csv";
    private static final String TO_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation.Type, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.Type.BALANCE, new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.PURCHASE, new DecreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.RETURN, new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.SUPPLY, new IncreaseOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FROM_FILE_NAME);
        DataParser<Operation, String> dataParser = new CsvOperationParser();
        List<Operation> operations = dataParser.formatData(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(operationStrategy);
        Map<String, Integer> calculateFruits = amountCalculator.calculateDataForReport(operations);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(TO_FILE_NAME, reportService.createReport(calculateFruits));
    }
}
