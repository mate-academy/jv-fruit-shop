package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.IOException;

public class CustomFileWriterImpl implements CustomFileWriter {
    public void write(String content, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
