package core.basesyntax;

import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.Operations;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
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
        fruitService.saveToStorage(new FileReaderImpl().read("src/main/resources/test1.cvs"));
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(fruitService.getReportFromStorage(),
                "src/main/resources/test1_output.cvs");
    }
}
