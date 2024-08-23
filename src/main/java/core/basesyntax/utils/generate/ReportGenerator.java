package core.basesyntax.utils.generate;

import core.basesyntax.storage.impl.StorageImpl;

public interface ReportGenerator {
    String getReport(StorageImpl storage);
}
