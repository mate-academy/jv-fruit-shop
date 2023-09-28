package core.basesyntax.service.fileservices;

import core.basesyntax.model.Operation;
import core.basesyntax.service.summaryofoperations.PreparationReportList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateReportFile {
    private final PreparationReportList createReportList;

    public CreateReportFile(PreparationReportList createReportList) {
        this.createReportList = createReportList;

    }

    public void createReportFile(String repotFilePath,
                                 Map<Operation, Map<String, List<Integer>>> fruitsStorage) {
        List<String> reportList = createReportList.createReportList(fruitsStorage);
        for (String reportData : reportList) {
            try (BufferedWriter bufferedWriter =
                         new BufferedWriter(new FileWriter(repotFilePath, true))) {
                bufferedWriter.write(reportData);
                bufferedWriter.write(System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file report.csv ", e);
            }
        }
    }
}
