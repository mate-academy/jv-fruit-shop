package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String CSV_FILE_NAME = "src/main/resources/reportTotalResult.csv";

    @Override
    public void writeFile(List<Transaction> list) {
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.println("fruit,quantity");
            for (Transaction result : list) {
                pw.println(result.getFruit() + "," + result.getQuantity());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create file " + CSV_FILE_NAME);
        }
    }
}
