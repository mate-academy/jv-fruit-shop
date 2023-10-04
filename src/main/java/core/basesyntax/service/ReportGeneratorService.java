package core.basesyntax.service;

import core.basesyntax.db.FruitShopStorage;

public interface ReportGeneratorService {
    String generateReport(FruitShopStorage fruitShopStorage);
}
