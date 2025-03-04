package service;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> read(String filePath) throws IOException;
}
