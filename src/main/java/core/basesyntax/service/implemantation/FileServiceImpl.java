package core.basesyntax.service.implemantation;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
  public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Didn't found file " + path);
        }
    }

    @Override
  public boolean writeToFile(String report, Path path) {
        byte[] stringBytes = report.getBytes();
        try {
            Files.write(path, stringBytes);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file");
        }
    }
}
