package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ReportCreatorService {
    List<String> createReport(List<Fruit> fruitInShopList);
}
