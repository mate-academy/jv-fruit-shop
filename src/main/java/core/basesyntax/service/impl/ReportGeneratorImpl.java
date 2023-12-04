package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String createReport(FruitDao fruitDao) {
        Set<Map.Entry<String, Integer>> fruits = fruitDao.getInventoryEntries();
        return fruits.stream()
                .map(e -> e.getKey() + ',' + e.getValue().toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
