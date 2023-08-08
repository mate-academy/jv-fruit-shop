package core.basesyntax.file.processing;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    private final String filePath;

    public CsvFileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writing(String report) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
