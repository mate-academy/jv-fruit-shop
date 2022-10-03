package core.basesyntax;

import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileReaderServiceImpl;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.CsvFileWriterServiceImpl;

import java.nio.file.Path;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final Path WRITE_TO_FILE = Path.of("src/main/resources/report.csv.txt");
    private static final Path READ_FILE_FROM = Path.of("src/main/resources/dailyActivities.csv.txt");
    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        List<String> readindLines = csvFileReaderService.readFromFile(READ_FILE_FROM);
        System.out.println(readindLines);
        csvFileWriterService.writeToFile("report", WRITE_TO_FILE);

    }
}
