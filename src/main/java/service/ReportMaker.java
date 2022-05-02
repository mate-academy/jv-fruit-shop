package service;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface ReportMaker {
    public String createReport(Set<Map.Entry<Fruit, Integer>> entrySet);
}
