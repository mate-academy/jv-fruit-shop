package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface Report {
    String createReport(List<Fruit> fruits);
}
