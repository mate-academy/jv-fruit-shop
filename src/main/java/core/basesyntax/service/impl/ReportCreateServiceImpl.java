package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportCreateService;
import java.util.stream.Collectors;

public class ReportCreateServiceImpl implements ReportCreateService {
    private static final String HEADER = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportCreateServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String create() {
        return HEADER + fruitDao.getAll().entrySet().stream()
                .map(f -> System.lineSeparator()
                        + f.getKey()
                        + ","
                        + f.getValue())
                .collect(Collectors.joining());
    }
}
