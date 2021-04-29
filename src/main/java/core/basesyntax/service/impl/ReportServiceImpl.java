package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String CONCATENATING_CHARACTER = ",";

    @Override
    public String getReportDataFromDB() {
        FruitDao fruitDao = new FruitDaoImpl();
        return TITLE_LINE + fruitDao.getFruits().stream()
                .map(fruit -> fruit.getName() + CONCATENATING_CHARACTER + fruitDao.get(fruit))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
