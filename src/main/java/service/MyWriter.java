package service;

import java.util.List;

public interface MyWriter {
    void writeToFile(List<String> data, String filePath);
}
