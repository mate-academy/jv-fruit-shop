package core.basesyntax.service.workwithfile;

import core.basesyntax.service.summaryofoperations.PreparationReportList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateReportFile {
    private final PreparationReportList createReportList = new PreparationReportList();

    public void createReportFile() {
        CreateFile createFile = new CreateFile();
        List<String> reportList = createReportList.createReportList();
        String file = createFile.createFile();
        for (String reportData : reportList) {
            try (BufferedWriter bufferedWriter =
                         new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(reportData);
                bufferedWriter.write(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file report.csv ", e);
            }
        }
    }
}
