package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.strategy.FruitBalance;
import core.basesyntax.dao.strategy.FruitOperations;
import core.basesyntax.dao.strategy.FruitPurchase;
import core.basesyntax.dao.strategy.FruitSupplyOrReturn;
import core.basesyntax.files.FileReader;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriter;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.service.validation.ValidatorImpl;
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
        FruitDao fruitDao = new FruitDaoImpl();
        Validator validator = new ValidatorImpl(operationStrategy, fruitDao);
        FruitService fruitService = new FruitServiceImpl(validator, operationStrategy, fruitDao);
        FileReader fileReader = new FileReaderImpl(fruitService);
        FileWriter fileWriter = new FileWriterImpl(fruitService);
        fileReader.readFromInputFile(FROM_FILE_PATH);
        fileWriter.writeToReport(TO_FILE_PATH);
    }
}
