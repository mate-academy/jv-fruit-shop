package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";
    private static final String ROW_SEPARATOR = System.lineSeparator();
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String buildReport() {
        Map<Fruit, Integer> fruitsMap = fruitDao.getAll();
        return HEADER + ROW_SEPARATOR + fruitsMap.entrySet().stream()
                .map(e -> e.getKey().getName() + DATA_SEPARATOR + e.getValue())
                .collect(Collectors.joining(ROW_SEPARATOR));
    }
}
