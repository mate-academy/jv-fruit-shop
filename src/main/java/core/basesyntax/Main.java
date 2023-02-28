package core.basesyntax;

import core.basesyntax.service.imp.CsvFileReaderService;
import core.basesyntax.service.imp.CsvFileWriterService;
import java.util.List;

public class Main {
    private static final String READ_FILE_NAME = "source.csv";
    private static final String WRITE_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> linesFromFile = csvFileReaderService.readFile(READ_FILE_NAME);

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.chooseStrategy(linesFromFile);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterService();
        csvFileWriterService.writeFile(WRITE_FILE_NAME);
    }
}
