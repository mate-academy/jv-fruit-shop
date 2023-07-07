package mate.academy.service.impl;

import java.util.Map;
import mate.academy.dao.FruitDao;
import mate.academy.dao.FruitDaoImpl;
import mate.academy.service.Report;

public class ReportImpl implements Report {
    private final String reportHeader;
    private final String dataSeparator;
    private final FruitDao fruitDao;

    public ReportImpl() {
        reportHeader = "fruit,quantity";
        dataSeparator = ",";
        fruitDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder().append(reportHeader);
        for (Map.Entry<String, Integer> entry : fruitDao.getAll().entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(dataSeparator)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
