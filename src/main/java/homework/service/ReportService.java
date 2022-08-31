package homework.service;

import homework.model.Fruit;
import java.util.Map;

public interface ReportService {
    public String report(Map<Fruit, Integer> dataBase);
}
