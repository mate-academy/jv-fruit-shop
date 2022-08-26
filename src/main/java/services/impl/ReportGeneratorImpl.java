package services.impl;

import dao.FruitDao;
import java.util.stream.Collectors;
import services.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String report() {
        return FIRST_LINE + fruitDao.getAll().entrySet().stream()
                .map(s -> System.lineSeparator() + s.getKey() + "," + s.getValue())
                .collect(Collectors.joining());
    }
}
