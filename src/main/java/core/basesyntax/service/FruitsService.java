package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public class FruitsService {
    private final CsvFileReader fileReader;
    private final CsvFileWriter fileWriter;
    private final DataToMapParser parser;

    public FruitsService(CsvFileReader fileReader, CsvFileWriter fileWriter,
                         DataToMapParser parser) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.parser = parser;
    }

    public boolean processFile(String inputFilePath, String outputFilesPath, Map<String,
            FruitOperations> operations) {
        List<FruitDto> data = fileReader.readFromFile(inputFilePath);
        Map<String, Map<String, Integer>> fruitStorage = parser.parseData(data, operations);
        fileWriter.writeToFile(fruitStorage, outputFilesPath);
        return true;
    }
}
