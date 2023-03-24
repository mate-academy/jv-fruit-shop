package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Set;

public interface ReportCreationService {
    List<String> getResult(Set<Fruit> fruits, StorageDao storageDao);
}
