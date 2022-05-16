package mate.academy.service;

import java.util.List;
import mate.academy.model.Fruit;

public interface ReportService {
    String getReport(List<Fruit> fruitList);
}
