package write.file;

import java.util.Map;

public interface WriteToFile {
    void write(Map<String, Integer> updatedFruitsStock,String filePath);
}
