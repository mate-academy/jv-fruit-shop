package core.basesyntax.service;

import core.basesyntax.db.StockDao;
import core.basesyntax.db.StockDaoStorageImpl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportToCsv implements Report {
    private static final String FILE_NAME = "report.csv";
    private final StockDao stockDao = new StockDaoStorageImpl();

    @Override
    public void prepare() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (String product : stockDao.getProductsList()) {
                writer.write(product + "," + stockDao.get(product) + System.lineSeparator());
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
