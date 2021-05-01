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
import core.basesyntax.service.Generator;
import core.basesyntax.service.GeneratorImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
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
        FruitDao fruitDao = new FruitDaoImpl();
        Validator validator = new ValidatorImpl(operationsMap, fruitDao);
        FruitService fruitService = new FruitServiceImpl(operationsMap, validator, fruitDao);
        Parser parser = new ParserImpl();
        Generator generator = new GeneratorImpl(fruitDao);
        FileReader fileReader = new FileReaderImpl();
        FileWriter fileWriter = new FileWriterImpl();
        fruitService.applyOperationsOnFruitsDto(parser.parseDto(fileReader.read(FROM_FILE_PATH)));
        fileWriter.write(TO_FILE_PATH, generator.generateReport());
    }
}
