package fm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileManagerCsvImpl implements FileManager {
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

    public List<String> getAllOperations(String csvFilePath) {
        try {
            return Files.readAllLines(Path.of(csvFilePath)).stream()
                    .skip(1)
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + csvFilePath);
        }
    }
}
