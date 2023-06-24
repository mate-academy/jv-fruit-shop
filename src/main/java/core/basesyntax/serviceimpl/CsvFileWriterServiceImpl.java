package core.basesyntax.serviceimpl;

import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    public static final String DELIMITER = ",";

    @Override
    public void writeDataToFileCsv(Map<String, String> lines, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : lines.entrySet()) {
                writer.write(entry.getKey() + DELIMITER + entry.getValue());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filePath, e);
        }

    }

}
