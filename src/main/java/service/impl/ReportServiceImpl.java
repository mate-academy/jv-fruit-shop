package service.impl;

import dao.DataDao;
import dao.impl.DataDaoImpl;
import java.util.Map;
import java.util.Set;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String DATA_SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();
    private static final DataDao dataDao = new DataDaoImpl();
    private static final Set<Map.Entry<String, Integer>> ENTRIES =
            dataDao.getFruitMap().entrySet();

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REPORT_HEADER);
        for (Map.Entry<String, Integer> e : ENTRIES) {
            stringBuilder.append(NEW_LINE)
                    .append(e.getKey())
                    .append(DATA_SEPARATOR)
                    .append(e.getValue());
        }
        stringBuilder.append(NEW_LINE);
        return stringBuilder.toString();
    }
}
