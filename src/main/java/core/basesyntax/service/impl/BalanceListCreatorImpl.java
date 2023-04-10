package core.basesyntax.service.impl;

import core.basesyntax.dao.GetAllRecords;
import core.basesyntax.dao.impl.GetAllRecordsImpl;
import core.basesyntax.service.BalanceListCreator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceListCreatorImpl implements BalanceListCreator {
    private static final String CSV_REPORT_TITLE = "fruit,quantity";
    private static final int TITLE_INDEX = 0;
    private static final String FRUIT_TRANSACTION_SEPARATOR = ",";

    @Override
    public List<String> create(Map<String, Integer> itemsQuantity) {
        GetAllRecords getAllRecords = new GetAllRecordsImpl();
        Map<String, Integer> reportMap = getAllRecords.get();
        List<String> dailyReportList = reportMap
                .entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + FRUIT_TRANSACTION_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.toList());
        dailyReportList.add(TITLE_INDEX, CSV_REPORT_TITLE);
        return dailyReportList;
    }
}
