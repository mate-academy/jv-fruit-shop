package core.basesyntax.service.imp;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reporter implements ReportService {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String SEPARATE_SYMBOL = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final StorageDao storageDao;

    public Reporter(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public List<String> getGoodsStockCsv() {
        Set<Map.Entry<String, Integer>> goodsStock = storageDao.getStock().entrySet();
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEAD);
        report.add(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> stock : goodsStock) {
            StringBuilder line = new StringBuilder()
                    .append(stock.getKey())
                    .append(SEPARATE_SYMBOL)
                    .append(stock.getValue())
                    .append(LINE_SEPARATOR);
            report.add(line.toString());
        }
        return report;
    }
}
