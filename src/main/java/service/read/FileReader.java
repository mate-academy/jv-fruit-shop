package service.read;

import java.util.List;

public interface FileReader {
    List<String> readFromFile(String filePath, String fileName);
}
