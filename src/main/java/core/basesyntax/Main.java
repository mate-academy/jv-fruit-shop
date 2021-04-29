package core.basesyntax;

import core.basesyntax.data.DataParser;
import core.basesyntax.data.FruitService;
import core.basesyntax.data.impl.FruitServiceImpl;
import core.basesyntax.data.impl.FruitShopDataParser;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.handlers.FruitsDecrement;
import core.basesyntax.handlers.FruitsIncrement;
import core.basesyntax.model.Operation;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.strategy.FruitsStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitsStrategy> fruitStrategies = new HashMap<>();
        FruitsStrategy fruitsIncreasing = new FruitsIncrement();
        FruitsStrategy fruitsDecreasing = new FruitsDecrement();
        fruitStrategies.put(Operation.getEnum("b"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("r"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("s"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("p"), fruitsDecreasing);

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReader.read(INPUT_FILE_PATH);

        DataParser dataParser = new FruitShopDataParser();
        List<TransactionDto> listWithFruits = dataParser.convert(dataFromFile);

        FruitService fruitService = new FruitServiceImpl(fruitStrategies);
        fruitService.applyOperationsOnFruitsDto(listWithFruits);
        String report = fruitService.generateReport();

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.write(report, REPORT_FILE_PATH);
    }
}
