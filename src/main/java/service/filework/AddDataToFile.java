package service.filework;

import java.util.Map;

public interface AddDataToFile {
    void addInStorage(Map<String, Integer> fruitAndQuantity, String filePath);
}
