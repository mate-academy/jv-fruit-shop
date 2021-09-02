package core.basesyntax;

import core.basesyntax.service.AmountCalculator;
import core.basesyntax.service.AmountCalculatorImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.StoreServiceImpl;
import core.basesyntax.service.data.DataFormatter;
import core.basesyntax.service.data.DataFormatterImpl;
import core.basesyntax.service.data.DataValidator;
import core.basesyntax.service.data.DataValidatorImpl;
import core.basesyntax.service.file.ReaderService;
import core.basesyntax.service.file.ReaderServiceImpl;
import core.basesyntax.service.file.WriterService;
import core.basesyntax.service.file.WriterServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE_NAME = "src/main/resources/input.csv";
    public static final String TO_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceOperationHandler());
        operationStrategyMap.put("p", new PurchaseOperationHandler());
        operationStrategyMap.put("r", new ReturnOperationHandler());
        operationStrategyMap.put("s", new SupplyOperationHandler());
        DataValidator dataValidator = new DataValidatorImpl();
        DataFormatter dataFormatter = new DataFormatterImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        AmountCalculator amountCalculator = new AmountCalculatorImpl(operationStrategy);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FROM_FILE_NAME);
        dataValidator.validate(dataFromFile);
        dataFormatter.formatData(dataFromFile);
        amountCalculator.calculate();
        StoreService storeService = new StoreServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        writerService.write(TO_FILE_NAME, storeService.createReport());
    }
}
