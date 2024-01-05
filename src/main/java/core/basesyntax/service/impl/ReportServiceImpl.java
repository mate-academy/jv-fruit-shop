package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_STRING = "fruit,quantity";
    private final FruitTransactionDao fruitTransactionDao;

    public ReportServiceImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_STRING)
                .append(System.lineSeparator());
        Set<Map.Entry<String, Integer>> transactionEntries = fruitTransactionDao.getAll()
                .entrySet();
        for (Map.Entry<String, Integer> transactionEntry : transactionEntries) {
            stringBuilder.append(transactionEntry.getKey())
                    .append(",")
                    .append(transactionEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
