package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        String listFromStorage = fruitDao.getStorageQuantity().keySet().stream()
                .map(k -> k + "," + fruitDao.getStorageQuantity().get(k) + "\n")
                .collect(Collectors.joining());
        return "fruit,quantity\n" + listFromStorage;
    }
}
