package core.basesyntax;

import core.basesyntax.dataservice.FruitAmountCounter;
import core.basesyntax.dataservice.FruitAmountCounterImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.DailyReportService;
import core.basesyntax.service.DailyReportServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.b, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.p, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.s, new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.r, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        FruitAmountCounter fruitAmountCounter
                = new FruitAmountCounterImpl(operationStrategy);
        DailyReportService dailyReportService = new DailyReportServiceImpl(fruitAmountCounter);
        dailyReportService.createReport(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }
}
