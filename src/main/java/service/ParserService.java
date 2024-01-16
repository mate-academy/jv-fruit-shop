package service;

import java.util.List;
import java.util.Map;

public interface ParserService {
    Map<String, Integer> parseData(List<String> dataFromFile);
}
