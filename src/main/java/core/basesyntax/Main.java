package core.basesyntax;

import core.basesyntax.dao.FileService;
import core.basesyntax.dao.FileServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();

        Map<String, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceOperationStrategy());
        operationStrategyMap.put("p", new PurchaseOperationStrategy());
        operationStrategyMap.put("s", new SupplyOperationStrategy());
        operationStrategyMap.put("r", new ReturnOperationStrategy());

        FruitService storeActivityService = new FruitServiceImpl(operationStrategyMap);

        String data = fileService.readData("src/main/resources/inputReport");
        String report = storeActivityService.getReport(data);
        fileService.makeReport(report, "src/main/resources/resultReport");
    }
}
