package service;

import java.io.File;
import java.util.List;

public interface ReaderService {
    void readDataFromFile(File file);
    List<String> getReadLines();
}
