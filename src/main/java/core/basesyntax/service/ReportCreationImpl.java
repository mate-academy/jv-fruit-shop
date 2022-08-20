package core.basesyntax.service;

import core.basesyntax.dao.FruitShopDao;
import java.util.stream.Collectors;

public class ReportCreationImpl implements ReportCreation {
    private static final String HEADER = "fruit,quantity";
    private final FruitShopDao fruitShopDao;

    public ReportCreationImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public String create() {
        return HEADER + fruitShopDao.getAll().entrySet().stream()
                .map(f -> System.lineSeparator()
                        + f.getKey()
                        + ","
                        + f.getValue())
                .collect(Collectors.joining());
    }
}
