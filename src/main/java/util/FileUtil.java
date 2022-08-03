package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    public List<String> getLineString(String pathFile) {
        try {
            return Files.readAllLines(Paths.get(pathFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + pathFile, e);
        }
    }

    public void writeFile(String path, String report) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file" + path + e);
        }
    }
}
