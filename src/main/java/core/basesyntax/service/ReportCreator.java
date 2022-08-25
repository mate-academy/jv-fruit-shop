package core.basesyntax.service;

import core.basesyntax.storage.Dao;

public interface ReportCreator {
    String generateReport(Dao dao);
}
