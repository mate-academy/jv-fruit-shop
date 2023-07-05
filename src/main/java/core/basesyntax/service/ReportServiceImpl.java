package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Override
    public List<String> createReport() {
        Map<String, Integer> storage = Storage.getStorage();
        List<String> dailyBalanceList =
                storage.entrySet()
                        .stream()
                        .map(s -> s.getKey().toString().toLowerCase()
                                + FruitTransactionParserImpl.SEPARATE_SYMBOL_FOR_CSV
                                + s.getValue())
                        .collect(Collectors.toList());
        dailyBalanceList.add(0, HEAD_OF_REPORT_TABLE);
        return dailyBalanceList;
    }
}
