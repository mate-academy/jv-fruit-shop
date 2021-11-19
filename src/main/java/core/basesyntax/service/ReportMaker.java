package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportMaker {
    String makeReport(List<Fruit> fruits);
}
