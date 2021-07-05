package core.basesyntax.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShopFileWriterImpl implements ShopFileWriter {
    @Override
    public boolean writeToFile(String data, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create file: " + fileName);
            }
        }
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName);
        }
        return true;
    }
}
