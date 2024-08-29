package core.basesyntax;

import core.basesyntax.reader.CsvFileReader;
import core.basesyntax.report.CsvFileWriter;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReader("testData1.csv");
        Map<String, Integer> fruitQuantities = csvFileReader.readTransactions();

        CsvFileWriter csvFileWriter = new CsvFileWriter("report.csv");
        csvFileWriter.writeReport(fruitQuantities);
    }
}
