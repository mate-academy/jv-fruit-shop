package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.stategy.OperationHandler;
import core.basesyntax.stategy.OperationStrategy;
import core.basesyntax.stategy.impl.BalanceOperationHandler;
import core.basesyntax.stategy.impl.PurchaseOperationHandler;
import core.basesyntax.stategy.impl.ReturnOperationHandler;
import core.basesyntax.stategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/input.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler>
                operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());

        List<String> inputData = new ReadServiceImpl().readInputData(INPUT_FILE_PATH);
        List<FruitTransaction> parseInputData =
                new ParseServiceImpl().parseInputData(inputData);

        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        OperationService operationService = new OperationService(operationStrategy);
        operationService.toFormStorage(parseInputData);

        String report = new ReportServiceImpl().createReport();
        System.out.println(report);

        WriteService writeService = new WriteServiceImpl();
        writeService.writeReport(report);
    }
}
