package core.service.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public void write(String fileReportPath, String report) {
        File file = new File(fileReportPath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File wasn't written!");
        }
    }
}
