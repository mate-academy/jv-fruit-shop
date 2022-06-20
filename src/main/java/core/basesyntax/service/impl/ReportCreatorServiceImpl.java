package core.basesyntax.service.impl;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.service.ReportCreatorService;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String HEAD = "fruit, quantity";
    private static final String SEPARATOR = ", ";
    private ShopDao shopDao = new ShopDaoImpl();

    public ReportCreatorServiceImpl(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public String createReport() {
        return HEAD + shopDao.getFruits().entrySet().stream()
                .map(i -> LINE_SEPARATOR + i.getKey()
                        + SEPARATOR + i.getValue())
                .collect(Collectors.joining());
    }
}
