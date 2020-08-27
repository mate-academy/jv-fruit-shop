package core.basesyntax.services;

import core.basesyntax.services.operations.Operable;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private final DataFileReader fileReader;
    private final DataFileWriter fileWriter;
    private final DataToMapParser parser;

    public FruitShopService(DataFileReader fileReader,
                            DataFileWriter fileWriter,
                            DataToMapParser parser) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.parser = parser;
    }

    public boolean processFile(String inputFilePath, String outputFilePath,
                               Map<String, Operable> operations) {

        List<String[]> data = fileReader.readDataFromFile(inputFilePath);
        Map<String, Map<String, Integer>> fruitStorage
                = parser.parseData(data, operations);
        fileWriter.writeResultsToFile(fruitStorage, outputFilePath);

        return true;
    }
}
