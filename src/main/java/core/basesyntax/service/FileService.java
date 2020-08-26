package core.basesyntax.service;

import java.util.List;

public interface FileService {
    List<String> read(String filePath);
    List<List<String>> readByPattern(String filePath, String pattern);
    void write(List<String> data, String fileName);
}
