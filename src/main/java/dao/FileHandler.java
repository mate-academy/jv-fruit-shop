package dao;

import java.util.List;

public interface FileHandler {
    List<String> readFile(String fileName);
    void writeFile(String filename, String report);
}
