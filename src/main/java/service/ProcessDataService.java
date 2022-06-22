package service;

import java.util.List;
import java.util.Map;

public interface ProcessDataService {
    Map<String, Integer> processData(List<String> dataFromFile);
}
