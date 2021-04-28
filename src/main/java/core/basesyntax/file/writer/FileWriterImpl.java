package core.basesyntax.file.writer;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String path, String fileContent) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            throw new RuntimeException("File not found by path " + path, e);
        }

    }
}
