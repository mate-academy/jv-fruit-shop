package core.basesyntax.report;

import core.basesyntax.model.Fruit;

import java.io.IOException;
import java.util.List;

public interface ReportMaker {
    void reportMaker(String path, List<Fruit> storage) throws IOException;
}
