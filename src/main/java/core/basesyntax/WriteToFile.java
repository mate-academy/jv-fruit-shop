package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private static final String REPORT_FILE = "report.csv";

    public void write(String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(REPORT_FILE, false))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + REPORT_FILE, e);
        }
    }
}
