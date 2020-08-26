package core.basesyntax.services;

import core.basesyntax.services.operations.Operable;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    public boolean processFile(String inputFilePath, String outputFilePath,
                               Map<String, Operable> operations) {
        DataFileReader fileReader = new DataFileReader();
        DataFileWriter fileWriter = new DataFileWriter();
        DataToMapParser parser = new DataToMapParser();

        List<String[]> data = fileReader.readDataFromFile(inputFilePath);
        Map<String, Map<String, Integer>> fruitStorage
                = parser.parseData(data, operations);
        fileWriter.writeResultsToFile(fruitStorage, outputFilePath);

        return true;
    }
}
