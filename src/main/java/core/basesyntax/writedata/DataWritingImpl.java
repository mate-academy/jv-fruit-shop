package core.basesyntax.writedata;

import core.basesyntax.report.ReportData;
import core.basesyntax.report.ReportDataImpl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWritingImpl implements DataWriting {
    private ReportData reportData;

    public void setReportData(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public void writeData(String fileReport) {
        setReportData(new ReportDataImpl());
        String[] strings = reportData.createDataReport();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReport, true))) {

            for (String data : strings) {
                writer.write(data + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file"
                    + fileReport, e);
        }
    }
}
