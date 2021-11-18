package core.basesyntax.service;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface ReportMaker {
    String makeReport(List<FruitCrate> storage);
}
