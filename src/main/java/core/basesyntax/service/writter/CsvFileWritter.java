package core.basesyntax.service.writter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWritter implements FileWritter {
    @Override
    public boolean write(String content, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(content);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
