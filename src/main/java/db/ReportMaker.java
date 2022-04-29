package db;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface ReportMaker {
    public StringBuilder reportMaker(Set<Map.Entry<Fruit, Integer>> entrySet);
}
