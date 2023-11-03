package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    @Override
    public boolean writeCvsFile(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new RuntimeException("Report or FilePath can` be null");
        }
        if (report.isEmpty()) {
            throw new RuntimeException("Your report is empty");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can not write report", e);
        }
    }
}
