package mate.academy.service.impl;

import java.util.Map;
import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.service.ReportGenerator;

public class ReportImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";
    private final FruitDao fruitDao;


    public ReportImpl() {
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
