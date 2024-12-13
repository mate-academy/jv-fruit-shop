package core.basesyntax.filewriter;

import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(content); // Записуємо текст у файл
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing file: " + filePath, e);
        }
    }
}
