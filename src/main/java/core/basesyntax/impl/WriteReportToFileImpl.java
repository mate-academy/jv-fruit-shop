package core.basesyntax.impl;

import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.WriteReportToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteReportToFileImpl implements WriteReportToFile {
    private static final String FILE_PATH = "src/main/java/core/basesyntax/report.csv";
    private GenerateReport generateReport = new GenerateReportImpl();

    @Override
    public void writeData(Map<String, Integer> fruits) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write(generateReport.generateReportString(fruits));
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}
