package core.basesyntax.readwritefile;

import core.basesyntax.readwritefile.interfaces.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvFileWriter implements FileWriter {
    public static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT.withHeader("fruit", "quantity");

    public CsvFileWriter() {
    }

    @Override
    public boolean writeCsv(Map<String, Integer> currentBalance, String pathName) {
        try (CSVPrinter printer = new CSVPrinter(new java.io.FileWriter(pathName), CSV_FORMAT)) {
            for (Map.Entry<String, Integer> entry : currentBalance.entrySet()) {
                printer.printRecord(entry.getKey(), entry.getValue());
            }
        } catch (IOException exception) {
            System.out.println(("file " + pathName + " is not written"));
            exception.printStackTrace();
        }
        return false;
    }
}
