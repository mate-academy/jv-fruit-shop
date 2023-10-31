package service;

import java.util.List;

public interface Reader {
    List<String> readDataFromFile(String transactionFullPath);
}
