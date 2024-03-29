package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileWriter;
import java.util.Map;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(Map<String, Integer> report, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report.toString());
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
