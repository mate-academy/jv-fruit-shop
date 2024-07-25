package core.basesyntex.service;

import core.basesyntex.service.impl.Storage;

public interface ReportGenerator {
    String getReport(Storage storage);
}
