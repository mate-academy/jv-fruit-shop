package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String CSV_SPLITTER = ",";
    private static final int HEADER_ROW_INDEX = 0;
    private static final int TYPE_COLUMN_INDEX = 0;
    private static final int FRUIT_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;
    private static final String REPORT_HEAD = "fruit" + CSV_SPLITTER + "quantity";
    private final StorageDao storageDao = new StorageDaoImpl();
    private final DataReader dataReader;
    private final ReportWriter reportWriter;
    private final ActivityStrategy activityStrategy;

    public FruitServiceImpl(ActivityStrategy activityStrategy,
                            DataReader dataReader,
                            ReportWriter reportWriter) {
        this.dataReader = dataReader;
        this.reportWriter = reportWriter;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void processData(String dataPath, String reportPath) {
        List<FruitTransaction> fruitTransactions = parseRows(dataReader.readData(dataPath));
        fruitTransactions.forEach(activityStrategy::doActivity);
        reportWriter.writeReport(reportPath, createReport());
    }

    private List<FruitTransaction> parseRows(List<String> rows) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        rows.remove(HEADER_ROW_INDEX);
        for (String row : rows) {
            String[] columns = row.split(CSV_SPLITTER);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperationById(columns[TYPE_COLUMN_INDEX]),
                    columns[FRUIT_COLUMN_INDEX],
                    Integer.parseInt(columns[QUANTITY_COLUMN_INDEX])
            ));
        }
        return fruitTransactions;
    }

    private String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEAD)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageDao.getEntrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(CSV_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }
}
