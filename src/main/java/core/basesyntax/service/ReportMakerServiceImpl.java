package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<String> makeReport(FruitDao fruitDao) {
        Map<Fruit, Integer> fruitsMap = fruitDao.getBalance();
        return fruitsMap.entrySet().stream()
                .map(e -> new StringBuilder().append(e.getKey().getName()).append(CSV_SEPARATOR)
                        .append(e.getValue()).append(System.lineSeparator()))
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }
}
