package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void createReportFile(String fruitBalanceReport) {
        File file = new File("src/main/resources/report.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(fruitBalanceReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
