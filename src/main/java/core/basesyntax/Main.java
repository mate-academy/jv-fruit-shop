package core.basesyntax;

import core.basesyntax.service.csvService.CsvReaderService;
import core.basesyntax.service.csvService.ReaderService;

import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/CsvInputData.csv";
    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderService();
        List<String> fileData = readerService.read(INPUT_FILE_PATH);


    }
}
