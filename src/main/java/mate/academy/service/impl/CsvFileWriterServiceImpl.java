package mate.academy.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import mate.academy.service.FileWriterService;

public class CsvFileWriterServiceImpl implements FileWriterService {
    public void write(Map<String, Integer> map, String toFileName) {
        File toFile = new File(toFileName);
        StringBuilder dataCsvFormat = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                dataCsvFormat.append(entry.getKey()).append(",")
                        .append(entry.getValue()).append(System.lineSeparator());
            }
            bufferedWriter.write(dataCsvFormat.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file" + toFileName, e);
        }
    }
}
