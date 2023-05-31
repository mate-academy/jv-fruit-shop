package core.basesyntax;

import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;

import java.util.List;

public class Main {
    private static final String READ_FILE_PATH
            = "src/main/java/resources/FruitStore_Data.csv";
    private static final String WRITE_FILE_PATH
            = "src/main/java/resources/FruitStore_Report.csv";

    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("-  --= Fuit shop =--  -");
        System.out.println("-----------------------");
        List<String> linesFormFile = new CsvFileReaderImpl().readFile(READ_FILE_PATH);
        for (String line :
                linesFormFile) {
            System.out.println(line);
        }
        System.out.println("--------------------------");
        CsvFileWriterImpl report = new CsvFileWriterImpl();
        report.writeFile(WRITE_FILE_PATH);


    }
}
