package servise.reader;

import java.nio.file.Path;
import java.util.List;

public interface Reader {
    List<String> readFromFile(String path);
}
