package service;

import java.util.List;
import java.util.Map;

public interface ReportCreator {
    List<String> create(Map<String, Integer> fruitTotalBalanceMap);
}
