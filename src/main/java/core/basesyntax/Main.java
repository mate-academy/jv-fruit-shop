package core.basesyntax;

import core.basesyntax.service.files.FruitService;
import core.basesyntax.service.files.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.dao.strategy.FruitBalance;
import core.basesyntax.dao.strategy.FruitOperations;
import core.basesyntax.dao.strategy.FruitPurchase;
import core.basesyntax.dao.strategy.FruitSupplyOrReturn;
import core.basesyntax.dao.validation.Validator;
import core.basesyntax.dao.validation.ValidatorImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH = "src/main/resources/input.csv";
    private static final String TO_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, FruitOperations> operationsMap = new HashMap<>();
        operationsMap.put("b", new FruitBalance());
        operationsMap.put("p", new FruitPurchase());
        operationsMap.put("r", new FruitSupplyOrReturn());
        operationsMap.put("s", new FruitSupplyOrReturn());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        Validator validator = new ValidatorImpl(operationStrategy);
        FruitDao fruitDao = new FruitDaoImpl(validator, operationStrategy);
        FruitService fruitService = new FruitServiceImpl(fruitDao);
        fruitService.readFromDb(FROM_FILE_PATH);
        fruitService.writeToReport(TO_FILE_PATH);
    }
}
