package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface ReportService {
    String getReport(List<Fruit> fruits);
}
