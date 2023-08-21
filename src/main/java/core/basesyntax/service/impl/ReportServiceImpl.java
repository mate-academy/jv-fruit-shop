package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_REPORT_COLUMN = "fruit";
    private static final String SECOND_REPORT_COLUMN = "quantity";
    private static final String SEPARATOR = ",";
    private static final String TITLE = FIRST_REPORT_COLUMN
            + SEPARATOR + SECOND_REPORT_COLUMN + System.lineSeparator();
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String create() {
        String result = fruitDao.getAll().stream()
                .map(fruit -> fruit.getName() + SEPARATOR
                        + fruit.getQuantity() + System.lineSeparator())
                .collect(Collectors.joining());

        return TITLE + result;
    }
}
