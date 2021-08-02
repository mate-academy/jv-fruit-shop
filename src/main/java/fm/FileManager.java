package fm;

import java.util.List;

public interface FileManager {
    void writeToFile(String filePath, String data);

    List<String> getAllOperations(String filePath);
}
