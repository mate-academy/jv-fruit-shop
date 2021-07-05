package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitFIleWriterImpl implements FruitFileWriter {
    @Override
    public void writeToFile(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to File" + filePath, e);
        }
    }
}
