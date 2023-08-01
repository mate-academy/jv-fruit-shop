package service.report;

import dao.DbDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbReporter implements Reporter {
    private static final String SPLIT_SYMBOL = ",";
    private static final String HEAD_TEXT = "fruit,quantity";
    private static final int HEAD_INDEX = 0;
    private DbDao dbDao;

    public DbReporter(DbDao dbDao) {
        this.dbDao = dbDao;
    }

    @Override
    public List<String> generate() {
        Map<String, Integer> data = dbDao.getData();
        List<String> report = new ArrayList<>();
        report.add(HEAD_INDEX, HEAD_TEXT);
        data.entrySet().stream()
                .forEach(x -> report.add(x.getKey() + SPLIT_SYMBOL + x.getValue()));
        return report;
    }
}
