package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    public static final String FILE_NAME = "src/main/resources/report.txt";

    @Override
    public void createReportFile(String fruitBalanceReport) {
        File file = new File(FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(fruitBalanceReport);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write report to the file by path: "
                    + FILE_NAME, e);
        }
    }
}
