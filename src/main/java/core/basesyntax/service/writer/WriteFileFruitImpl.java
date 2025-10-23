package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileFruitImpl implements WriteFileFruit {
    @Override
    public void writeAll(String content, String filePath) {
        if (content == null || content.isBlank()) {
            throw new RuntimeException("Output content must not be null or blank");
        }
        if (filePath == null || filePath.isBlank()) {
            throw new RuntimeException("Output file path must not be null or blank");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filePath, e);
        }
    }
}
