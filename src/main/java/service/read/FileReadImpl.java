package service.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + path, e);
        }
        dataFromFile.remove(0);
        return dataFromFile;
    }
}
