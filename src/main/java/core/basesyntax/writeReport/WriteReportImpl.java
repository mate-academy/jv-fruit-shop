package core.basesyntax.writeReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportImpl implements WriteReport{
    private static final String PATH = "src/main/resources/report.txt";
    @Override
    public void writeReportToFile(String report) {
        File file = new File(PATH);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
