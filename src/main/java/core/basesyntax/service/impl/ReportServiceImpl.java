package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> createReport(String line) {
        List<String> list = fruitDao.getAll()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "," + e.getValue().toString())
                .collect(Collectors.toList());
        list.add(0, line);
        return list;
    }
}
