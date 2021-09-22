package fruitshop.service.reporthandlers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private static final String FILE_CREATION_ERROR_NOTIFICATION
            = "Can't create the file";
    private static final String FILE_WRITING_ERROR_NOTIFICATION = "Can`t write to file";

    public File writeToFile(String fruitShopReport, String reportFileName) {
        File dailyReport = new File(reportFileName);
        try {
            dailyReport.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(FILE_CREATION_ERROR_NOTIFICATION, e);
        }
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(dailyReport))) {
            writer.write(fruitShopReport);
        } catch (IOException e) {
            throw new RuntimeException(FILE_WRITING_ERROR_NOTIFICATION, e);
        }
        return dailyReport;
    }
}
