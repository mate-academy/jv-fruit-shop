package core.basesyntax.reporter;

import core.basesyntax.dao.FruitStorageDao;

public interface ReportGenerator {
    String generateReport(FruitStorageDao fruitStorageDao);
}
