package core.basesyntax;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.impl.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        DataReader dataReader = new FileReader();
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveToStorage(dataReader.readData("src/main/resources/test1_correct.csv"));
        System.out.println(fruitService.getFromStorage());
    }
}
