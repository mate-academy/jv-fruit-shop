package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportService;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private final String REPORT_HEADER;
    private final String DATA_SEPARATOR;
    private final FruitDao fruitDao;

    public ReportServiceImpl() {
        REPORT_HEADER = "fruit,quantity";
        DATA_SEPARATOR = ",";
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder().append(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : fruitDao.getAll().entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DATA_SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
