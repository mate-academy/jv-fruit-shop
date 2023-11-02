package core.basesyntax.service.writter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWritter implements FileWritter {
    private static final String EXCEPTION_MESSAGE = "Can't write file";

    @Override
    public boolean write(String content, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(content);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE, e);
        }

    }
}
