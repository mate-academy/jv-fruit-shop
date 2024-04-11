package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    public static final String WORD_SEPARATOR = ",";
    public static final String LINE_SEPARATOR = "\n";

    @Override
    public String create(List<FruitTransaction> fruitTransactions) {
        StorageDao storageDao = new StorageDaoImpl();
        StringBuilder report = new StringBuilder("fruit,quantity");
        fruitTransactions = fruitTransactions.stream()
                .distinct()
                .map(fruit -> {
                    if (storageDao.get(fruit.getFruit()).getQuantity() < 0) {
                        throw new RuntimeException("Balance should be positive: "
                                + fruit
                                + ","
                                + storageDao.get(fruit.getFruit()).getQuantity());
                    } else {
                        return fruit;
                    }
                }).collect(Collectors.toList());
        fruitTransactions.forEach(fruit -> {
            report.append(LINE_SEPARATOR);
            report.append(fruit.getFruit());
            report.append(WORD_SEPARATOR);
            report.append(storageDao.get(fruit.getFruit()).getQuantity());
        });
        return report.toString();
    }
}
