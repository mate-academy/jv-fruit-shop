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
import core.basesyntax.service.file.DataWriter;
import core.basesyntax.service.file.impl.DataValidatorImpl;
import core.basesyntax.service.file.impl.FileReader;
import core.basesyntax.service.file.impl.FileWriter;
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
        DataReader dataReader = new FileReader(new DataValidatorImpl());
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveToStorage(dataReader.readData("src/main/resources/test1_correct.csv"));
        DataWriter dataWriter = new FileWriter();
        dataWriter.writeToFile(fruitService.getFromStorage(), "src/main/resources/result");
        System.out.println(fruitService.getFromStorage());
    }
}
