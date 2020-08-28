package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.List;
import java.util.Map;

public interface ReportBuilder {
    Map<String, Integer> buildReport(List<Storage.FruitBox> data);
}
