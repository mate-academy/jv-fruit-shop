package fruitshop.service.impl;

import fruitshop.service.WriteReportToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteReportToFileImpl implements WriteReportToFile {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();

    @Override
    public void writeReportToFile(Map<String, Integer> reportText, File toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(TITLE);
            for (Map.Entry<String, Integer> entry : reportText.entrySet()) {
                bufferedWriter.write(entry.getKey() + ","
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("can't write data to file: " + toFile);
        }
    }
}
