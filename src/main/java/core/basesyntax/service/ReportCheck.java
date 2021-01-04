package core.basesyntax.service;

import core.basesyntax.dao.Warehouse;

public interface ReportCheck {
    void readFromReport(String filName, Warehouse warehouse);

    void writeToReport(Warehouse warehouse);
}
