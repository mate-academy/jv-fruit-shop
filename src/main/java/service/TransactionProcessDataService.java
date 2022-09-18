package service;

import java.util.List;
import java.util.Map;

public interface TransactionProcessDataService {
    Map<String, Integer> processData(List<String> data);
}
