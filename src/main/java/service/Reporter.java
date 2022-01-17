package service;

import java.util.List;
import java.util.Map;

public interface Reporter {
    Map<String, Integer> report(List<String> data);
}
