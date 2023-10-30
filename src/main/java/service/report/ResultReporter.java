package service.report;

import dao.Dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultReporter implements Reporter {
    private static final String SPLIT_SYMBOL = ",";
    private static final String HEAD_TEXT = "fruit,quantity";
    private static final int HEAD_INDEX = 0;
    private Dao dao;

    public ResultReporter(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<String> generate() {
        Map<String, Integer> data = dao.getStock();
        List<String> report = new ArrayList<>();
        report.add(HEAD_INDEX, HEAD_TEXT);
        data.entrySet().stream()
                .forEach(entry -> report.add(entry.getKey() + SPLIT_SYMBOL + entry.getValue()));
        return report;
    }
}
