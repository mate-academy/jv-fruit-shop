package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportDaoImpl implements ReportDao {
    private static final String ERROR_MESSAGE = "Can`t write data to CSV file ";

    @Override
    public void writeReportToCsvFile(String report, File toFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + toFile, e);
        }
    }
}
