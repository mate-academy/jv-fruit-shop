package service;

import java.util.List;

//Interface for reading the information from the file.
public interface ReadFromFile {
    List<String> readFromCsvFile(String filePath);
}
