package core.basesyntax;

import core.basesyntax.dto.TransactionDto;
import core.basesyntax.handlers.DecrementFruit;
import core.basesyntax.handlers.IncrementFruit;
import core.basesyntax.model.Operation;
import core.basesyntax.services.DataParser;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.impl.DataParserImpl;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.FruitServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitStrategy> fruitStrategyMap = new HashMap<>();
        FruitStrategy incrementFruit = new IncrementFruit();
        FruitStrategy decrementFruit = new DecrementFruit();

        fruitStrategyMap.put(Operation.getOperation("s"), incrementFruit);
        fruitStrategyMap.put(Operation.getOperation("b"), incrementFruit);
        fruitStrategyMap.put(Operation.getOperation("r"), incrementFruit);
        fruitStrategyMap.put(Operation.getOperation("p"), decrementFruit);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.read(INPUT_FILE);

        DataParser dataParser = new DataParserImpl();
        List<TransactionDto> fruitsList = dataParser.parse(dataFromFile);

        FruitService fruitService = new FruitServiceImpl(fruitStrategyMap);
        fruitService.applyOperation(fruitsList);
        String report = fruitService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, REPORT_FILE);
    }
}
