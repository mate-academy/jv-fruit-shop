package core.basesyntax.service.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        return Storage.getInventory().toString();
    }
}
