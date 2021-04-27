package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.strategy.FruitBalance;
import core.basesyntax.service.strategy.FruitOperations;
import core.basesyntax.service.strategy.FruitPurchase;
import core.basesyntax.service.strategy.FruitSupplyOrReturn;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.service.validation.ValidatorImpl;
import core.basesyntax.service.works.WorkWithStorage;
import core.basesyntax.service.works.WorkWithStorageImpl;
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
        WorkWithStorage workWithStorage = new WorkWithStorageImpl(validator, operationStrategy);
        FruitDao fruitDao = new FruitDaoImpl(workWithStorage);
        fruitDao.readFromDb(FROM_FILE_PATH);
        fruitDao.writeToReport(TO_FILE_PATH);
    }
}
