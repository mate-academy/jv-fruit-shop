package service.write;

import java.util.Map;

public interface WriteService {
    void write(String resultString, String pathToWrite);

    String prepareToWrite(Map<String, Integer> fruitValueMap);
}
