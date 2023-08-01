package core.basesyntax.files;

import core.basesyntax.exceptions.FileException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    private static final String COMA_SEPARATOR = ",";

    @Override
    public void writeReport(Map<String, Integer> data, String reportPath) {
        File file = new File(reportPath);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new FileException("Can't create report file ", e);
        }
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true))) {
            for (Map.Entry<String, Integer> line : data.entrySet()) {
                writer.write(line.getKey());
                writer.write(COMA_SEPARATOR);
                writer.write(String.valueOf(line.getValue()));
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new FileException("Can't write data in file", e);
        }

    }
}
