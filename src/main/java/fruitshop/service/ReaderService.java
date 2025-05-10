package fruitshop.service;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String filePath);
}
