package core.basesyntax.file.processing;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterImpl implements CsvFileWriter {
    public static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writing(String report) {
        try (FileWriter writer = new FileWriter(REPORT_FILE_PATH)) {
            writer.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + REPORT_FILE_PATH, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
