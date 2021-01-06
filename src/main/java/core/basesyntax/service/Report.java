package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface Report<T extends Fruit> {
    String generateReport(List<T> fruits);
}
