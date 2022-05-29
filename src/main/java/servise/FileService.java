package servise;

import java.util.List;
import java.util.Map;

public interface FileService {
    List<String> getDbFromFile(String fileName);

    void putDbToFile(Map<String, Integer> dayResult);
}
