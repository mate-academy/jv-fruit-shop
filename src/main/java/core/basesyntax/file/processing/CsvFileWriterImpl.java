package core.basesyntax.file.processing;

import java.io.FileWriter;

public class CsvFileWriterImpl implements CsvFileWriter {
    private final String filePath;

    public CsvFileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writing(String report) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}
