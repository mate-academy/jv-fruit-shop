package core.basesyntax;

import core.basesyntax.data.DataParser;
import core.basesyntax.data.FruitService;
import core.basesyntax.data.impl.FruitServiceImpl;
import core.basesyntax.data.impl.FruitShopDataParser;
import core.basesyntax.model.Operation;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.handlers.FruitsDecrement;
import core.basesyntax.handlers.FruitsIncrement;
import core.basesyntax.services.FileServiceReader;
import core.basesyntax.services.FileServiceWritter;
import core.basesyntax.services.InputFileCreator;
import core.basesyntax.services.impl.FileServiceReaderImpl;
import core.basesyntax.services.impl.FileServiceWritterImpl;
import core.basesyntax.services.impl.InputFileCreatorImpl;
import core.basesyntax.strategy.FruitsStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        InputFileCreator inputFileCreator = new InputFileCreatorImpl();
        inputFileCreator.create(INPUT_FILE_PATH);

        Map<Operation, FruitsStrategy> fruitStrategies = new HashMap<>();
        FruitsStrategy fruitsIncreasing = new FruitsIncrement();
        FruitsStrategy fruitsDecreasing = new FruitsDecrement();
        fruitStrategies.put(Operation.getEnum("b"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("r"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("s"), fruitsIncreasing);
        fruitStrategies.put(Operation.getEnum("p"), fruitsDecreasing);

        FileServiceReader fileServiceReader = new FileServiceReaderImpl();
        List<String> dataFromFile = fileServiceReader.read(INPUT_FILE_PATH);

        DataParser dataParser = new FruitShopDataParser();
        List<TransactionDto> listWithFruits = dataParser.convert(dataFromFile);

        FruitService dataAnalyzer = new FruitServiceImpl(fruitStrategies);
        dataAnalyzer.applyOperationsOnFruitsDto(listWithFruits);
        String report = dataAnalyzer.generateReport();

        FileServiceWritter fileServiceWritter = new FileServiceWritterImpl();
        fileServiceWritter.write(report, REPORT_FILE_PATH);
    }
}
