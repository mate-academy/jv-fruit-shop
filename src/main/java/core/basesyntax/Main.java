package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.CSVFileReaderServiceImpl;

import java.util.List;

public class Main {

    private static final String INPUT_DATA_PATH = "src/main/resources/inputData.csv";
//    private static final String OUTPUT_DATA_PATH = ;

    public static void main(String[] args) {
        FileReaderService fileReaderService = new CSVFileReaderServiceImpl();
        List<FruitTransaction> fruitTransactions = fileReaderService.readDataFile(INPUT_DATA_PATH);
    }
}
