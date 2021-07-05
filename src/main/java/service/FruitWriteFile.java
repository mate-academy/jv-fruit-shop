package service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FruitWriteFile implements WriteFile {
    @Override
    public boolean writeToFile(String fileName, String report) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file" + fileName, e);
        }
        try {
            Files.write(file.toPath(),report.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
        return true;
    }
}
