package core.basesyntax.services.writes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterOrderImpl implements CsvFileWriterOrder {
    private static final String EXCEPTION_TEXT = "An error occurred during recording";

    @Override
    public boolean writerOrder(String content, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_TEXT, e);
        }
    }
}
