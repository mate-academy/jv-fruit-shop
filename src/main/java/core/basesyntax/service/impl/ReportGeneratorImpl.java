package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final Map<String, Integer> storageQuantity = fruitDao.getStorageQuantity();

    @Override
    public String getReport() {
        String listFromStorage = storageQuantity.keySet().stream()
                .map(k -> k + "," + storageQuantity.get(k) + "\n")
                .collect(Collectors.joining());
        return "fruit,quantity\n" + listFromStorage;
    }
}
