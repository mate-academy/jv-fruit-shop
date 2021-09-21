package service;

import java.util.Map;

public interface WriteFile {
    void writeWithMapToFile(Map<String, Integer> map, String newFileName);
}
