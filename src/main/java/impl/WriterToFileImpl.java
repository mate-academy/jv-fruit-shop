package impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterToFile;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeReportToFile(String report, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file ", e);
        }
    }
}
