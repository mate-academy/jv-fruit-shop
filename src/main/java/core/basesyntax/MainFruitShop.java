package core.basesyntax;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.DataFileParser;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.DataFileParserImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;

import java.util.List;

public class MainFruitShop {
    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.readFromFile(INPUT_DATA_FILE);

        DataFileParser<FruitOperation> operationDataFileParser = new DataFileParserImpl();
        List<FruitOperation> fruitOperations = operationDataFileParser.parseDataFile(data);




    }
}
