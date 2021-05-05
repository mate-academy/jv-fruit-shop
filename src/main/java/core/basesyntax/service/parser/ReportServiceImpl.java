package core.basesyntax.service.parser;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.fruitmodel.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String generateReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : fruitDao.getAll().entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString().trim();
    }
}
