package core.basesyntax;

import core.basesyntax.fruittransact.FruitTransactionService;
import core.basesyntax.reportcreator.ReportCreator;
import core.basesyntax.reportcreator.ReportCreatorImpl;
import core.basesyntax.workwithfile.filereader.CsvFileReader;
import core.basesyntax.workwithfile.filereader.CsvFileReaderImpl;
import java.io.File;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionService();
        ReportCreator reportCreator = new ReportCreatorImpl();
        for (String fileName : FILE_NAMES) {
            fruitTransactionService.transactAll(csvFileReader.readFromFile(new File(fileName)));
            System.out.println(reportCreator.generateReport() + System.lineSeparator());
        }
    }
}
