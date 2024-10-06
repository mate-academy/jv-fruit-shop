package dao;

import java.util.Map;
//FileWriter
public interface FileWriter {
    void writeFile(String fileName, Map<String, Integer> inventory);
}
