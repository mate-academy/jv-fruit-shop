package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface WriteReportService {
    void writeReport(List<Fruit> fruitDb, String filePath);
}
