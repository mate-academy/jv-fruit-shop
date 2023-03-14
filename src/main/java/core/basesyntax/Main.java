package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.services.ShopReportService;
import core.basesyntax.servicesimpl.ShopReportServiceImpl;
import core.basesyntax.strategy.OperarionHandlerPurchase;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerReturn;
import core.basesyntax.strategy.OperationHandlersSupply;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static final String INPUT_DATA_PATH = "src/main/resources/FruitShopInputData.csv";
    public static final String REPORT_DATA_PATH = "src/main/resources/FruitShopOutputData.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getCode(),new OperationHandlerBalance());
        operationHandlerMap.put(OperationType.SUPPLY.getCode(),new OperationHandlersSupply());
        operationHandlerMap.put(OperationType.RETURN.getCode(),new OperationHandlerReturn());
        operationHandlerMap.put(OperationType.PURCHASE.getCode(),new OperarionHandlerPurchase());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ShopReportService reportService = new ShopReportServiceImpl(operationStrategy);
        reportService.createReport(Path.of(INPUT_DATA_PATH), Path.of(REPORT_DATA_PATH));
    }
}
