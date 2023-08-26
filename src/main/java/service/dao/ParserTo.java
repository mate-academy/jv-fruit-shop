package service.dao;

import java.util.List;
import java.util.Map;

public interface ParserTo {
    List<String> parsedListToFile(Map<String,Integer> map);
}
