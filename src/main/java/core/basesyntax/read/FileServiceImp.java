package core.basesyntax.read;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImp implements FileServiceInt {
    @Override
    public List<String> readFile(String filePath) {
        Path path = Paths.get(filePath);
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
