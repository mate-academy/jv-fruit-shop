package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String COMA_SYMBOL = ",";
    private final List<String> finalReport = new ArrayList<>();

    @Override
    public List<String> getResult(Set<Fruit> fruits, StorageDao storageDao) {
        for (Fruit fruit : fruits) {
            int quantity = storageDao.getQuantity(fruit);
            finalReport.add(fruit.getName() + COMA_SYMBOL + quantity);
        }
        return finalReport;
    }
}
