package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_STRING = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public StringBuilder makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_STRING)
                .append(System.lineSeparator());
        List<Fruit> allFruits = fruitDao.getAll();
        for (int i = 0; i < allFruits.size(); i++) {
            stringBuilder.append(allFruits.get(i)
                            .getName())
                    .append(",")
                    .append(allFruits.get(i)
                            .getQuantity());
            if (i + 1 != allFruits.size()) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder;
    }
}
