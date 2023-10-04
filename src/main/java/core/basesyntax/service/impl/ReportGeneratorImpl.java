package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMA_SYMBOL = ",";
    private final List<String> finalReport = new ArrayList<>();

    @Override
    public List<String> generateReport(StorageDao storageDao) {
        Set<Fruit> fruits = Storage.getStorage().keySet();
        for (Fruit fruit : fruits) {
            int quantity = storageDao.getQuantity(fruit);
            finalReport.add(fruit.getName() + COMA_SYMBOL + quantity);
        }
        return finalReport;
    }
}
