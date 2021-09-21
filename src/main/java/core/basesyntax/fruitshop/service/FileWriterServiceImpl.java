package core.basesyntax.fruitshop.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    public void writeToFile(String data, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + e);
        }
    }
}
