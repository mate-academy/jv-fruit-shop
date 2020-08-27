package core.basesyntax.readWriteFile;

import com.opencsv.CSVParser;
import com.opencsv.CSVWriter;
import core.basesyntax.readWriteFile.interfaces.IWriteCSV;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteCSV implements IWriteCSV {
    public static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT.withHeader("fruit", "quantity");

    public WriteCSV() {
    }

    @Override
    public boolean writeCSV(Map<String, Integer> currentBalance, String pathName) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(pathName), CSV_FORMAT)) {
            for (Map.Entry<String, Integer> entry : currentBalance.entrySet()) {
                printer.printRecord(entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException exception) {
            System.out.println(("file " + pathName + " does not exist"));
        } catch (IOException exception) {
            System.out.println(("file " + pathName + " is not written"));
            exception.printStackTrace();
        }
        return false;
    }
}
