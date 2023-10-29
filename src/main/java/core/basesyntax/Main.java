package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/java/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler>
                operationHandlerMap = initializeOperationHandlers();

        ReadService readService = new ReadServiceImpl();
        List<String> inputData = readService.readInputData(INPUT_PATH);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> parsedInputData = parseService.parseInputData(inputData);

        OperationStrategy strategy = new OperationStrategy(operationHandlerMap);
        OperationService service = new OperationService(strategy);
        service.processOperation(parsedInputData);

        String report = new ReportServiceImpl().createReport();

        WriterService writerService = new WriteServiceImpl();
        writerService.writeToFile(OUTPUT_PATH, report);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> initializeOperationHandlers() {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        return operationHandlerMap;
    }
}
