package servise.readfromfile;

import java.nio.file.Path;
import java.util.List;

public interface ReadFromFile {
    List<String> readFromFile(Path path);
}
