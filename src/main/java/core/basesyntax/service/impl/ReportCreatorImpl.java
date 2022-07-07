package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";
    private final FruitShopDao fruitShopDao;

    public ReportCreatorImpl(FruitShopDao fruitShopDao) {
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
