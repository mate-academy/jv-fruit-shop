package service;

import java.util.Map;

public interface ProcessDataService {
    Map<String, Integer> processData(String[] dataFromFile);
}
