package database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFile(String inputName) {
        try {
            return Files.readAllLines(new File(inputName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("cant read file", e);
        }
    }

    @Override
    public void writeToFile(String filePath, String data) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Can't create file " + filePath, e);
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, false))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
