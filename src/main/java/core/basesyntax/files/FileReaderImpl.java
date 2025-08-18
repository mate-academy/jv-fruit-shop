package core.basesyntax.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        Path pathToFile = new File(path).toPath();
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException("Cant read from file", e);
        }
        return list;
    }

}
