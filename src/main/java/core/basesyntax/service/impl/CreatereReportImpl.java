package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.CreatereReport;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CreatereReportImpl implements CreatereReport {
    @Override
    public String createReport(FruitDao fruitDao) {
        HashMap<String, Integer> fruits = fruitDao.getStorage().getFruits();
        return fruits.entrySet().stream()
                .map(e -> e.getKey() + ',' + e.getValue().toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
