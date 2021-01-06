package core.basesyntax;

import core.basesyntax.model.BalanceOperation;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationStrategy;
import core.basesyntax.model.OperationStrategyImpl;
import core.basesyntax.model.Operations;
import core.basesyntax.model.PurchaseOperation;
import core.basesyntax.model.ReturnOperation;
import core.basesyntax.model.SupplyOperation;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.BALANCE, new BalanceOperation());
        operationMap.put(Operations.PURCHASE, new PurchaseOperation());
        operationMap.put(Operations.SUPPLY, new SupplyOperation());
        operationMap.put(Operations.RETURN, new ReturnOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveToStorage(new FileReaderImpl().read("src/test/resources/test1.cvs"));
        System.out.println(fruitService.getReportFromStorage());
    }
}
