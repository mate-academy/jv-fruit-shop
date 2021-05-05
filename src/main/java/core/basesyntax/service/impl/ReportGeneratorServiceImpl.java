package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dao.FruitDao;
import core.basesyntax.model.dao.FruitDaoImpl;
import core.basesyntax.service.interfaces.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String DELIMITER = ",";
    private final FruitDao fruitDao;

    public ReportGeneratorServiceImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE);
        Map<Fruit, Integer> fruitMap = fruitDao.getAll();
        for (Map.Entry<Fruit, Integer> entry : fruitMap.entrySet()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
