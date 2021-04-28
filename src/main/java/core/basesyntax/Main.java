package core.basesyntax;

import core.basesyntax.data.DataAnalyzer;
import core.basesyntax.data.DataParser;
import core.basesyntax.data.ReportCreator;
import core.basesyntax.data.impl.FruitShopAnalyzer;
import core.basesyntax.data.impl.FruitShopDataParser;
import core.basesyntax.data.impl.FruitShopReportCreator;
import core.basesyntax.dto.Dto;
import core.basesyntax.handlers.FruitsDecrement;
import core.basesyntax.handlers.FruitsIncrement;
import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FileServiceReader;
import core.basesyntax.services.FileServiceWritter;
import core.basesyntax.services.FruitsStrategy;
import core.basesyntax.services.InputFileCreator;
import core.basesyntax.services.impl.FileServiceReaderImpl;
import core.basesyntax.services.impl.FileServiceWritterImpl;
import core.basesyntax.services.impl.InputFileCreatorImpl;
import core.basesyntax.storage.FruitDataBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        InputFileCreator inputFileCreator = new InputFileCreatorImpl();
        inputFileCreator.create(INPUT_FILE_PATH);
        FruitDataBase fruitDataBase = new FruitDataBase();
        fruitDataBase.setFruitShopData("apple", 0);
        fruitDataBase.setFruitShopData("banana", 0);

        Map<Operations, FruitsStrategy> fruitStrategies = new HashMap<>();
        FruitsStrategy fruitsIncreasing = new FruitsIncrement();
        FruitsStrategy fruitsDecreasing = new FruitsDecrement();
        fruitStrategies.put(Operations.getEnum("b"), fruitsIncreasing);
        fruitStrategies.put(Operations.getEnum("r"), fruitsIncreasing);
        fruitStrategies.put(Operations.getEnum("s"), fruitsIncreasing);
        fruitStrategies.put(Operations.getEnum("p"), fruitsDecreasing);

        FileServiceReader fileServiceReader = new FileServiceReaderImpl();
        List<String> dataFromFile = fileServiceReader.read(INPUT_FILE_PATH);

        DataParser dataParser = new FruitShopDataParser();
        List<Dto> listWithFruits = dataParser.convert(dataFromFile);

        DataAnalyzer dataAnalyzer = new FruitShopAnalyzer(fruitDataBase, fruitStrategies);
        dataAnalyzer.analyze(listWithFruits);

        ReportCreator reportCreator = new FruitShopReportCreator(fruitDataBase);
        FileServiceWritter fileServiceWritter = new FileServiceWritterImpl();
        fileServiceWritter.write(reportCreator.generateReport(), REPORT_FILE_PATH);
    }
}
