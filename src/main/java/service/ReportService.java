package service;

import java.util.Map;
import model.Fruit;

public interface ReportService {
    public String report(Map<Fruit, Integer> dataBase);
}
