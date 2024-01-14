package core.basesyntax.writereport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements ReportWriter {

    @Override
    public void writeReportToFile(String report, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file.getName(), e);
        }
    }
}
