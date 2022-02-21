package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportCreator {
    String createReport(List<Fruit> fruits);
}
