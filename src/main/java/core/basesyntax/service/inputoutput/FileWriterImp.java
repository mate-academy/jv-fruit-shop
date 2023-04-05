package core.basesyntax.service.inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImp implements FileWriter {
    @Override
    public void write(String filePath, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + filePath, e);
        }
    }
}
