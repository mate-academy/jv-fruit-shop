package fruitshop.service.reporthandlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RepotrToFIleConverter implements ReportSupplier {
    private static final String FILE_CREATION_ERROR_NOTIFICATION
            = "Can't create the file";
    private static final String FILE_WRITING_ERROR_NOTIFICATION = "Can`t write to file";

    public File writeToFile(ReportGenerator stringReportGenerator, String reportFileName) {
        String report = stringReportGenerator.generateReport();
        File dailyReport = new File(reportFileName);
        try {
            dailyReport.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(FILE_CREATION_ERROR_NOTIFICATION, e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dailyReport))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(FILE_WRITING_ERROR_NOTIFICATION, e);
        }
        return dailyReport;
    }
}
