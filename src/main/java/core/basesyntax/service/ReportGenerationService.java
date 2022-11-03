package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportGenerationService {
    List<String> createReport(List<Fruit> fruitInShopList);

    void saveReport(List<String> report, String toFilePath);
}
