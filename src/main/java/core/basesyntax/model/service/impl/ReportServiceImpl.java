package core.basesyntax.model.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity\n";
    private static final String ELEMENT_DELIMITER = ",";
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> fruitQuantities = fruitStorageDao.getAllFruit();

        String report = fruitQuantities.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ELEMENT_DELIMITER + entry.getValue())
                .collect(Collectors.joining("\n"));

        return HEADER + report;
    }
}
