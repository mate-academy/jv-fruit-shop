package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;

public interface ReportGenerator {
    String generateReport(FruitDao storageDao);
}
