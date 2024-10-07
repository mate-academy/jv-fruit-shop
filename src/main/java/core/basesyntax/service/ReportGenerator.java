package core.basesyntax.service;

import core.basesyntax.db.Inventory;

public interface ReportGenerator {
    String getReport(Inventory inventory);
}
