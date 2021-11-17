package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.List;

public interface ReportMaker {
    String makingReport(List<FruitBox> data);
}
