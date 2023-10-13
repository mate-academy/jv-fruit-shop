package core.basesyntax;

import core.basesyntax.fruittransact.FruitTransactionService;
import core.basesyntax.reportcreator.ReportGenerator;
import core.basesyntax.reportcreator.ReportGeneratorImpl;
import core.basesyntax.workwithfile.filereader.CsvFileReader;
import core.basesyntax.workwithfile.filereader.FileReader;
import java.io.File;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        FruitTransactionService fruitTransactionService = new FruitTransactionService();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        for (String fileName : FILE_NAMES) {
            fruitTransactionService.handleAll(fileReader.readFromFile(new File(fileName)));
            System.out.println(reportGenerator.generateReport() + System.lineSeparator());
        }
    }
}
