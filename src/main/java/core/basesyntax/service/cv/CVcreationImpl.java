package core.basesyntax.service.cv;

import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class CVcreationImpl implements CVcreation {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public CVcreationImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createCV() {
        Map<String, Integer> storage = fruitDao.getStorage();
        StringBuilder report = new StringBuilder();
        report.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey()).append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

}
