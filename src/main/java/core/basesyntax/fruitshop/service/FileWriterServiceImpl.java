package core.basesyntax.fruitshop.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    public void writeToFile(String toWrite, String toFile) {
        File file = new File(toFile);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + e);
        }
    }
}
