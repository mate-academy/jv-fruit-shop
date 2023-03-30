package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.implementation.CreateReportServiceImplementation;
import core.basesyntax.service.implementation.ReadFromFileServiceImplementation;
import core.basesyntax.service.implementation.WriteToFileServiceImplementation;
import core.basesyntax.service.operationhandler.BalanceOperationHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseOperationHandler;
import core.basesyntax.service.operationhandler.ReturnOperationHandler;
import core.basesyntax.service.operationhandler.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImplementation;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();

        operationHandlersMap.put(FruitTransaction.Operation.BALANCE.getOperation(),
                new BalanceOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.PURCHASE.getOperation(),
                new PurchaseOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.RETURN.getOperation(),
                new ReturnOperationHandler());
        operationHandlersMap.put(FruitTransaction.Operation.SUPPLY.getOperation(),
                new SupplyOperationHandler());

        OperationStrategy operationStrategy =
                new OperationStrategyImplementation(operationHandlersMap);

        ReadFromFileService readFromFileService =
                new ReadFromFileServiceImplementation();
        WriteToFileService writeToFileService =
                new WriteToFileServiceImplementation();
        CreateReportService createReportService =
                new CreateReportServiceImplementation(operationStrategy);

        String dataFromFile = readFromFileService.readFromFile("src/main/resources/startFile.csv");
        String report = createReportService.createReport(dataFromFile);
        writeToFileService.writeToFile(report, "src/main/resources/resultFile.csv");
    }
}
