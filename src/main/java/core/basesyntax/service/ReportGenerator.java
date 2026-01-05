package core.basesyntax.service;

import core.basesyntax.db.Inventory;
import java.util.List;

public interface ReportGenerator {
    public List<String> getReport(Inventory inventory);
}
