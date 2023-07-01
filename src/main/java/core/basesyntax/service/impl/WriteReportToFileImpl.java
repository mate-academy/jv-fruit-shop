package core.basesyntax.service.impl;

import core.basesyntax.service.WriteReportToFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteReportToFileImpl implements WriteReportToFile {
    @Override
    public void writeReportToFile(Map<String, Integer> fruitReport, String reportFileName) {
        try (FileWriter writer = new FileWriter(reportFileName)) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : fruitReport.entrySet()) {
                String fruit = entry.getKey();
                int quantity = entry.getValue();
                writer.write(fruit + "," + quantity + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: ", e);
        }
    }
}
