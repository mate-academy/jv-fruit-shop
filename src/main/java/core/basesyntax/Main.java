package core.basesyntax;

import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.OperationProcessorService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.validation.impl.OutputValidatorImpl;
import core.basesyntax.validation.impl.ReaderValidationImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resourses/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resourses/report.csv";
    private static Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    static {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
    }

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);

        List<String> data = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        List<String> validationData = new ReaderValidationImpl().validate(data);
        List<FruitTransaction> transactions = new TransactionParserServiceImpl()
                .parse(validationData);

        OperationProcessorService processorService = new OperationProcessorService();
        processorService.process(transactions, operationStrategy);

        String report = new ReportServiceImpl().generateReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_PATH);
        new OutputValidatorImpl().validateFile(OUTPUT_FILE_PATH);
    }
}
