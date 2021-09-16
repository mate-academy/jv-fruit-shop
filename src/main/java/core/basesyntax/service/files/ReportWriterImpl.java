package core.basesyntax.service.files;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.FruitRecord;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    private static final String REPORT_HEADER = "fruitRecord,quantity";
    private static final String DATA_DIVIDER = ",";

    @Override
    public void writeReportToFile(String filename) {
        FruitsDao fruitDao = new FruitsDaoImpl();
        List<FruitRecord> fruitsDbRecords = fruitDao.getRecords();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(REPORT_HEADER + System.lineSeparator());
            for (FruitRecord record : fruitsDbRecords) {
                String fruitName = record.getFruit().getFruitName();
                int fruitsAmount = record.getAmount();
                bw.write(fruitName + DATA_DIVIDER + fruitsAmount + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file, " + e);
        }
    }
}
