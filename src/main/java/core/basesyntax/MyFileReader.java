package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class MyFileReader {
    public List<String> getDryInfo(File file) {
        List<String> info;
        try {
            info = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        info.remove(0);
        return info;
    }
}
