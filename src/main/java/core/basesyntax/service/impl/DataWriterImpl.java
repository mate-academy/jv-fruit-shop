package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class DataWriterImpl implements DataWriter {

    @Override
    public void writeData(String report, String toFile) {

        try (FileWriter fileWriter = new FileWriter(toFile);
                CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {
            String[] lines = report.split(System.lineSeparator());
            for (String line : lines) {
                String[] fields = line.split(",");
                csvPrinter.printRecord(fields[0], Integer.parseInt(fields[1]));
            }
            System.out.println("Data successfully written to " + toFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't wrote report to file" + toFile, e);
        }
    }
}
