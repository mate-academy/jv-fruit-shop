package app.service;

import java.util.List;

public interface FileReadService {
    List<List<String>> readFile(String filePath);
}
