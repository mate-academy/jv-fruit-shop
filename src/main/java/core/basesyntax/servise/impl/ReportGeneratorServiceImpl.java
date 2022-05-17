package core.basesyntax.servise.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.servise.ReportGeneratorService;
import java.util.List;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final StorageDao storageDao;

    public ReportGeneratorServiceImpl() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public String generate() {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        List<String> allFruits = storageDao.getAllFruits();
        for (String allFruit : allFruits) {
            reportBuilder.append(allFruit)
                    .append(",")
                    .append(storageDao.getQuantity(allFruit))
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
