package service;

import java.util.List;

public interface FileService {
    List<String> read(String fromFile);

    void write(String toFile, String report);

}
