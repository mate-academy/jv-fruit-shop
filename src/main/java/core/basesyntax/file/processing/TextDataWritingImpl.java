package core.basesyntax.file.processing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TextDataWritingImpl implements TextDataWriting {
    public static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    @Override
    public void writing(String report) {
        try (FileWriter writer = new FileWriter(REPORT_FILE_PATH)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
