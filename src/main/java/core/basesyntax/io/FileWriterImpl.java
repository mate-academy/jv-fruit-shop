package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file", e);
        }
    }
}
