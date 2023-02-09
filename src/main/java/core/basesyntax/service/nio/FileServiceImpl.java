package core.basesyntax.service.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String pathFromRepository) {
        try {
            return Files.readAllLines(Path.of(pathFromRepository)).stream()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("is not correct file " + e);
        }
    }

    @Override
    public void write(String string, String path) {
        String replace = string.trim().replace(" ", ",");
        try {
            Files.write(Path.of(path), replace.concat("\n").getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("is not correct url... " + e);
        }
    }
}
