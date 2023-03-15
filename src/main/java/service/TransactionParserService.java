package service;

import java.util.List;
import java.util.Map;

public interface TransactionParserService {
    Map<String, Integer> saveToStorage(List<String> list);
}
