package sevice.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import service.FileReaderService;

public class FileReader implements FileReaderService {

    public List<String> readFromFile(String filePath) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + filePath, e);
        }
        return dataFromFile.stream()
                .skip(1)
                .collect(Collectors.toList());
    }
}


