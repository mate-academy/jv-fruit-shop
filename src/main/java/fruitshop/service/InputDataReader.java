package fruitshop.service;

import java.util.List;

public interface InputDataReader {
    List<String> readFromFile(String inputFilePath);
}
