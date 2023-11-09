package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class DataWriterImpl implements DataWriter {

    private static final String CSV_FILE_NAME = "src/main/resources/report.csv";

    @Override
    public void writeData(Map<String, Integer> dataBase) {

        try (FileWriter fileWriter = new FileWriter(CSV_FILE_NAME);
                CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Fruit", "Value");
            for (Map.Entry<String, Integer> entry : dataBase.entrySet()) {
                csvPrinter.printRecord(entry.getKey(), entry.getValue());
            }
            System.out.println("Data successfully written to " + CSV_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
