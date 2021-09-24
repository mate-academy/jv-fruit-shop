package service.inter;

import java.util.Map;

public interface WriteService {
    void writeToFile(String filePath, Map<String, Integer> fruitsQuantity);
}
