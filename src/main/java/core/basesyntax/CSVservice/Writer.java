
package core.basesyntax.CSVservice;

import core.basesyntax.Storage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    public static void write(String fileName) {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("fruit","quantity");
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(fileName), format)) {
            for (Map.Entry<String, Integer> item : Storage.storage.entrySet()) {
                printer.printRecord(item.getKey(), item.getValue());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with writing to file");
        }
    }
}
