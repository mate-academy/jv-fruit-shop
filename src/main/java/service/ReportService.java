package service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportService {
    StringBuilder outputString = new StringBuilder();
    String createReport(List<Fruit> storage);
}
