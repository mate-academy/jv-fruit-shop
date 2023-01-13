package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADER = "fruit,quantity";
    private static final char SEPARATOR = ',';
    private final FruitDao fruitDao;

    public ReportCreatorServiceImpl() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        Map<String, Integer> fruitStorage = fruitDao.getAll();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
