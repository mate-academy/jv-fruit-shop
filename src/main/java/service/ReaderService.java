package service;

import java.util.List;

public interface ReaderService {
    List<String[]> readFromCsv(String filePath);
}
