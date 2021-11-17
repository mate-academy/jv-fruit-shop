package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitCrate;
import core.basesyntax.service.ReportMaker;
import java.util.Comparator;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    private StorageDao storageDao;

    public ReportMakerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String makeReport(StorageDao storageDao) {
        List<FruitCrate> storage = storageDao.getAll();
        Comparator<FruitCrate> fruitCrateComparator =
                Comparator.comparing(FruitCrate::getName);
        storage.sort(fruitCrateComparator);
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (FruitCrate fruitCrate : storage) {
            reportBuilder.append(fruitCrate.getName()).append(",")
                    .append(fruitCrate.getQuantity()).append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }
}
