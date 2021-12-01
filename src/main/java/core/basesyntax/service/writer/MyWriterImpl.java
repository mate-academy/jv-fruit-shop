package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyWriterImpl implements MyWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write data to the file " + fileName, e);
        }
    }
}
