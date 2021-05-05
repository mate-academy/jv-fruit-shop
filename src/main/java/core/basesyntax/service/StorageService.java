package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageService {
    Map<Fruit,Integer> getAllData();

}
