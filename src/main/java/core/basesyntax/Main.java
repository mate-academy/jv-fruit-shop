package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.AmountCalculator;
import core.basesyntax.service.AmountCalculatorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.StoreServiceImpl;
import core.basesyntax.service.data.DataToOperationsFormatter;
import core.basesyntax.service.data.DataToOperationsFormatterImpl;
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
        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.Type.BALANCE.getType(), new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.PURCHASE.getType(), new DecreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.RETURN.getType(), new IncreaseOperationHandler());
        operationStrategyMap.put(Operation.Type.SUPPLY.getType(), new IncreaseOperationHandler());
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FROM_FILE_NAME);
        DataToOperationsFormatter dataToOperationsFormatter = new DataToOperationsFormatterImpl();
        List<Operation> operations = dataToOperationsFormatter.formatData(dataFromFile);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(operationStrategy);
        Map<String, Integer> calculateFruits = amountCalculator.calculate(operations);
        StoreService storeService = new StoreServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(TO_FILE_NAME, storeService.createReport(calculateFruits));
    }
}
