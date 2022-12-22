package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportDaoImpl implements ReportDao {
    private static final String TO_FILE_NAME = "src/main/resources/toFile.csv";
    private static final File TO_FILE = new File(TO_FILE_NAME);

    @Override
    public void writeReportToCsvFile(String report) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(TO_FILE, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to CSV file " + TO_FILE_NAME);
        }
    }
}
