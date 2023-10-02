package core.service;

import core.exception.ReportWriteException;
import core.service.impl.WriteReportService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportServiceImpl implements WriteReportService {
    private static final String FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String PATH_DEFAULT = "src/main/";

    @Override
    public void createReport(String filePathTo, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                PATH_DEFAULT + filePathTo))) {
            writer.write(FIRST_LINE + report);
        } catch (IOException e) {
            throw new ReportWriteException("Can't write data in file " + filePathTo);
        }
    }
}
