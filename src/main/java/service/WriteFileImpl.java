package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class WriteFileImpl implements WriteFile {

    @Override
    public void writeWithMapToFile(Map<String, Integer> map, String reportPath) {
        File file = new File(reportPath);
        try (Writer writer = new FileWriter(file)) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file, " + reportPath, e);
        }
    }
}
