package core.basesyntax.service.impl;

import core.basesyntax.service.WriteScvService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteScvServiceIml implements WriteScvService {
    @Override
    public void writeDataScvFile(String data, String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
