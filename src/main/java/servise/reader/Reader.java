package servise.reader;

import java.util.List;

public interface Reader {
    List<String> readFromFile(String path);
}
