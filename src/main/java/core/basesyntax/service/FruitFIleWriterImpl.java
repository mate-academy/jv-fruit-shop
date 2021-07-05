package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FruitFIleWriterImpl implements FruitFileWriter {
    @Override
    public void writeToFile(String data, Path filePath) {
        File file = new File(String.valueOf(filePath));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to File" + file.getName(), e);
        }
    }
}
