package service.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<String> fileReader(String inputFile) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + inputFile, e);
        }
        dataFromFile.remove(0);
        return dataFromFile;
    }
}
