package database;

import java.util.List;

public interface FileService {

    List<String> readFile(String inputName);

    void writeToFile(String filePath, String data);
}
